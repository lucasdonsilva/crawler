package br.com.crawler.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.crawler.constants.RegexConstants;

import static br.com.crawler.constants.RegexConstants.*;
import static java.util.regex.Pattern.compile;

public class MatcherRegex {
	
	private static Matcher getMatcher(String regex, String content) {
		return compile(regex).matcher(content);
	}

	public static Matcher getItemMatcher(String content) {
		return getMatcher(ITEM.getExpression(), content);
	}
	
	public static Matcher getDescriptionMatcher(String content) {
		return getMatcher(DESCRIPTION.getExpression(), content);
	}
	
	public static Matcher getDescriptionParagraphAndDivMatcher(String content) {
		return getMatcher(DESCRIPTION_P_DIV.getExpression(), content);
	}
	
	public static Matcher getDescriptionImageAndUnorderedListMatcher(String content) {
		return getMatcher(DESCRIPTION_IMG_UL.getExpression(), content);
	}
	
	public static Matcher getDescriptionHyperlinkMatcher(String content) {
		return getMatcher(DESCRIPTION_HYPERLINK.getExpression(), content);
	}
}