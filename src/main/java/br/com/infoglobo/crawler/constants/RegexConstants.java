package br.com.infoglobo.crawler.constants;

public enum RegexConstants {

	ITEM("<item>(.*?)</item>"),
	DESCRIPTION("<(title|link|description)>(.*?)</(?:title|link|description)>"),
	DESCRIPTION_P_DIV("<(p|div)(?:.*?)>(.*?)</(?:p|div)>"),
	DESCRIPTION_IMG_UL("<ul>(.*?)</ul>|<(img).*?src=['\"]{1}([^>]*?)['\"]{1}.*?>"),
	DESCRIPTION_HYPERLINK("<a.*?href=['\"]{1}([^>]*?)['\"]{1}.*?>");
	
	public String regex;

	public String getRegex() {
		return regex;
	}

	RegexConstants(String regex) {
		this.regex = regex;
	}

}
