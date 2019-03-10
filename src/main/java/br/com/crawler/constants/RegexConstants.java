package br.com.crawler.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RegexConstants {

	ITEM("<item>(.*?)</item>"),
	DESCRIPTION("<(title|link|description)>(.*?)</(?:title|link|description)>"),
	DESCRIPTION_P_DIV("<(p|div)(?:.*?)>(.*?)</(?:p|div)>"),
	DESCRIPTION_IMG_UL("<ul>(.*?)</ul>|<(img).*?src=['\"]{1}([^>]*?)['\"]{1}.*?>"),
	DESCRIPTION_HYPERLINK("<a.*?href=['\"]{1}([^>]*?)['\"]{1}.*?>");

    public String expression;
}
