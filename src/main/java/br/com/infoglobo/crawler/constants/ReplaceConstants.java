package br.com.infoglobo.crawler.constants;

public enum ReplaceConstants {

	CDATA("\\<\\!\\[CDATA\\[|\\]\\]\\>"),
	HTML_TAGS("<[^>]*>"),
	HTML_STABILIZER("\t|\r|\n|&nbsp;");
	
	public String replace;
	
	public String getReplace() {
		return replace;
	}

	ReplaceConstants(String replace) {
		this.replace = replace;
	}
	
}
