package br.com.crawler.exception;

public class IntegrationException extends RuntimeException{
	public IntegrationException(final String message, final Exception e){
		super(message, e);
	}
}
