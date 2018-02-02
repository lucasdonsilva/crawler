package br.com.infoglobo.crawler.service;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.infoglobo.crawler.constants.ReplaceConstants;
import br.com.infoglobo.crawler.util.MatcherRegex;
import br.com.infoglobo.crawler.util.Reader;
import br.com.infoglobo.crawler.util.Stabilizer;
import br.com.infoglobo.crawler.vo.Description;
import br.com.infoglobo.crawler.vo.Feed;
import br.com.infoglobo.crawler.vo.Item;
import br.com.infoglobo.crawler.vo.ListContentDescription;
import br.com.infoglobo.crawler.vo.SingleContentDescription;

@Service
public class FeedServiceImpl implements FeedService{
	
	@Value("${feed.url}")
	private URL url;
	
	/**
	 * Obtem a Lista de feed preenchida.
	 */
	@Override
	public List<Feed> getFeed() {

		String content = Reader.getContentStream(url);
		
		String stabilizeContent = Stabilizer.getHtmlStabilized(content);
		
		List<Feed> feed = new ArrayList<>();
		
		this.getItems(stabilizeContent, feed);
		
		return feed;
	}
	
	/**
	 * Obtem a lista de items
	 * @param content
	 * @param feeds
	 */
	private void getItems(String content, List<Feed> feeds) {

		Matcher matcher = MatcherRegex.getItemMatcher(content);
		
		while (matcher.find()) {
			Feed feed = new Feed();
			Item item = new Item();
			
			String innerContent = matcher.group(1);
			this.getDescription(innerContent, item);
			
			feed.setItem(item);
			feeds.add(feed);
		}
	}
	
	/**
	 * Obtem as descrições por item
	 * @param content
	 * @param item
	 */
	private void getDescription(String content, Item item) {

		Matcher matcher = MatcherRegex.getDescriptionMatcher(content);
		while (matcher.find()) {
			String tagName = matcher.group(1);
			String innerContent = matcher.group(2);

			switch (tagName) {
			case "title":
				item.setTitle(innerContent.replaceAll(ReplaceConstants.CDATA.getReplace(), ""));
				break;
				
			case "link":
				item.setLink(innerContent);
				break;

			default:
				this.getParagraphAndDiv(innerContent, item);
				break;
			}
		}

	}
	
	/**
	 * Obtem <p> e <div>
	 * @param content
	 * @param item
	 */
	private void getParagraphAndDiv(String content, Item item) {

		Matcher matcher = MatcherRegex.getDescriptionParagraphAndDivMatcher(content);
		List<Description> descriptions = new ArrayList<>();
		while (matcher.find()) {
			String tagName = matcher.group(1);
			String innerContent = matcher.group(2);
			if ("p".equals(tagName)) {
				String pText = innerContent.replaceAll(ReplaceConstants.HTML_TAGS.getReplace(), "");
				if (!pText.isEmpty()) {
					
					SingleContentDescription singleContentDescription = new SingleContentDescription();
					singleContentDescription.setType("text");
					singleContentDescription.setContent(pText);
					
					descriptions.add(singleContentDescription);
				}
			} else {
				Description description = this.getImageAndUnorderedList(innerContent);
				if (description != null) {
					descriptions.add(description);
				}				
			}
		}
		
		item.setDescriptions(descriptions);

	}
	
	/**
	 * Obtem <img> e <ul>
	 * @param content
	 * @return
	 */
	private Description getImageAndUnorderedList(String content) {

		Matcher matcher = MatcherRegex.getDescriptionImageAndUnorderedListMatcher(content);
		while (matcher.find()) {
			String ulContent = matcher.group(1);
			String tagName = matcher.group(2);
			String src = matcher.group(3);

			if ("img".equals(tagName)) {
				
				SingleContentDescription singleContentDescription = new SingleContentDescription();
				singleContentDescription.setType("image");
				singleContentDescription.setContent(src);
				
				return singleContentDescription;
			} else {
				return getHyperlink(ulContent);
			}
		}
		
		return null;
	}
	
	/**
	 * Obtem hyperlink
	 * @param content
	 * @return
	 */
	private Description getHyperlink(String content) {

		Matcher matcher = MatcherRegex.getDescriptionHyperlinkMatcher(content);
		
		ListContentDescription listDescription = null;
		List<String> descriptionList = new ArrayList<>();
		
		while (matcher.find()) {
			String href = matcher.group(1);		
			
			descriptionList.add(href);			
		}
		
		if (!descriptionList.isEmpty()) {
			listDescription = new ListContentDescription();
			listDescription.setType("links");
			listDescription.setContent(descriptionList);
		}
		
		return listDescription;
	}

	/**
	 * Obtem o valor de url
	 * @return
	 */
	public URL getUrl() {
		return url;
	}
	
	/**
	 * Seta o valor em url
	 * @param url
	 */
	public void setUrl(URL url) {
		this.url = url;
	}
	
}
