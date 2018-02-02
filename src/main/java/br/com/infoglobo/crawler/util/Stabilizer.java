package br.com.infoglobo.crawler.util;

import org.apache.commons.text.StringEscapeUtils;

import br.com.infoglobo.crawler.constants.ReplaceConstants;

public class Stabilizer {
	
	public static String getHtmlStabilized(String html){
		String htmlStabilized = StringEscapeUtils.unescapeHtml4(html.replaceAll(ReplaceConstants.HTML_STABILIZER.getReplace(), "").trim());
		return htmlStabilized;
	}
	
}
