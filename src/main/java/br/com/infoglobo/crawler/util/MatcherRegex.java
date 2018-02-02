package br.com.infoglobo.crawler.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.infoglobo.crawler.constants.RegexConstants;

public class MatcherRegex {
	
	private static Matcher getMatcher(String regex, String content) {
		Pattern p = Pattern.compile(regex);
		return p.matcher(content);
	}

	public static Matcher getItemMatcher(String content) {
		return MatcherRegex.getMatcher(RegexConstants.ITEM.getRegex(), content);
	}
	
	public static Matcher getDescriptionMatcher(String content) {
		return MatcherRegex.getMatcher(RegexConstants.DESCRIPTION.getRegex(), content);
	}
	
	public static Matcher getDescriptionParagraphAndDivMatcher(String content) {
		return MatcherRegex.getMatcher(RegexConstants.DESCRIPTION_P_DIV.getRegex(), content);
	}
	
	public static Matcher getDescriptionImageAndUnorderedListMatcher(String content) {
		return MatcherRegex.getMatcher(RegexConstants.DESCRIPTION_IMG_UL.getRegex(), content);
	}
	
	public static Matcher getDescriptionHyperlinkMatcher(String content) {
		return MatcherRegex.getMatcher(RegexConstants.DESCRIPTION_HYPERLINK.getRegex(), content);
	}
	
}
