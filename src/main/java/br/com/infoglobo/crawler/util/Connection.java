package br.com.infoglobo.crawler.util;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.infoglobo.crawler.constants.MessageConstants;
import br.com.infoglobo.crawler.exception.IntegrationException;

public class Connection {

	private static final Logger LOGGER = LoggerFactory.getLogger(Connection.class);
	
	public static URLConnection getUrlConnection(URL url){
		
		try{
			return url.openConnection();
		}catch(IOException e){
			String message = MessageConstants.ERRO_CONEXAO.getMessage() + url.toString();
			LOGGER.error(message, e);
			throw new IntegrationException(message, e);
		}
		
	}
	
}
