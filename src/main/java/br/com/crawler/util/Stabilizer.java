package br.com.crawler.util;

import static br.com.crawler.constants.ReplaceConstants.HTML_STABILIZER;
import static org.apache.logging.log4j.util.Strings.EMPTY;
import static org.springframework.web.util.HtmlUtils.htmlUnescape;

public class Stabilizer {
	
	public static String getHtmlStabilized(String html) {
        return htmlUnescape(html.replaceAll(HTML_STABILIZER.getReplace(), EMPTY));
    }
}