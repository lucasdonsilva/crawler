package br.com.crawler.service;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;

import br.com.crawler.constants.ReplaceConstants;
import lombok.Setter;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.crawler.util.MatcherRegex;
import br.com.crawler.util.Reader;
import br.com.crawler.util.Stabilizer;
import br.com.crawler.vo.Description;
import br.com.crawler.vo.Feed;
import br.com.crawler.vo.Item;
import br.com.crawler.vo.ListContentDescription;
import br.com.crawler.vo.SingleContentDescription;

import static br.com.crawler.constants.ReplaceConstants.CDATA;
import static br.com.crawler.constants.ReplaceConstants.HTML_TAGS;
import static br.com.crawler.constants.TagConstants.*;
import static br.com.crawler.util.MatcherRegex.*;
import static br.com.crawler.util.Reader.getContentStream;
import static br.com.crawler.util.Stabilizer.getHtmlStabilized;
import static java.util.Objects.nonNull;
import static org.apache.logging.log4j.util.Strings.EMPTY;

@Service
public class FeedService{
	
	@Value("${feed.url}")
    @Setter
	private URL url;
	
	public List<Feed> getFeed() {

		List<Feed> feed = new ArrayList<>();
		String content = getHtmlStabilized(getContentStream(url));
		getItems(content, feed);
		
		return feed;
	}

	private void getItems(String content, List<Feed> feeds) {

		Matcher matcher = getItemMatcher(content);

		while (matcher.find()) {
			Item item = new Item();
			getDescription(matcher.group(1), item);
			feeds.add(new Feed(item));
		}
	}
	
	private void getDescription(String content, Item item) {

		Matcher matcher = getDescriptionMatcher(content);

		while (matcher.find()) {
			String innerContent = matcher.group(2);

			switch (matcher.group(1)) {
			case TITLE:
				item.setTitle(innerContent.replaceAll(CDATA.getReplace(), EMPTY));
				break;
				
			case LINK:
				item.setLink(innerContent);
				break;

			default:
				getParagraphAndDiv(innerContent, item);
				break;
			}
		}
	}
	
	private void getParagraphAndDiv(String content, Item item) {

		Matcher matcher = getDescriptionParagraphAndDivMatcher(content);
		List<Description> descriptions = new ArrayList<>();

		while (matcher.find()) {
			String innerContent = matcher.group(2);

			if (P.equals(matcher.group(1))) {
				String pText = innerContent.replaceAll(HTML_TAGS.getReplace(), EMPTY);
				if (!pText.isEmpty()) descriptions.add(new SingleContentDescription(TEXT, pText));
			} else {
				Description description = getImageAndUnorderedList(innerContent);
				if (nonNull(description)) descriptions.add(description);
			}
		}
		
		item.setDescriptions(descriptions);
	}
	
	private Description getImageAndUnorderedList(String content) {

		Matcher matcher = getDescriptionImageAndUnorderedListMatcher(content);

		while (matcher.find()) {
			if (IMG.equals(matcher.group(2))) return new SingleContentDescription(IMAGE, matcher.group(3));
			else return getHyperlink(matcher.group(1));
		}
		
		return null;
	}
	
	private Description getHyperlink(String content) {

		List<String> descriptionList = new ArrayList<>();
		Matcher matcher = getDescriptionHyperlinkMatcher(content);
		while (matcher.find()) descriptionList.add(matcher.group(1));
		if (!descriptionList.isEmpty()) return new ListContentDescription(LINKS, descriptionList);
		
		return null;
	}
}