package br.com.infoglobo.crawler.exception;

public class IntegrationException extends RuntimeException{

	private static final long serialVersionUID = 2916158381618080501L;

	public IntegrationException(final String message, final Exception e){
		super(message, e);
	}
	
}
