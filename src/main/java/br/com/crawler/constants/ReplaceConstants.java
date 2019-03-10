package br.com.crawler.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ReplaceConstants {

	CDATA("\\<\\!\\[CDATA\\[|\\]\\]\\>"),
	HTML_TAGS("<[^>]*>"),
	HTML_STABILIZER("\t|\r|\n|&nbsp;");
	
	public String replace;
}
