package br.com.infoglobo.crawler.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import br.com.infoglobo.crawler.constants.MessageConstants;
import br.com.infoglobo.crawler.exception.IntegrationException;

@Component
public class Reader {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Reader.class);
	
	private static InputStreamReader getInputStream(URL url){
		
		URLConnection urlConnection = Connection.getUrlConnection(url);
		
		try{
			InputStreamReader is = new InputStreamReader(urlConnection.getInputStream());
			
			return is;
		}catch(IOException e){
			String message = MessageConstants.ERRO_CRIACAO_STREAM.getMessage() + url.toString();
			LOGGER.error(message);
			throw new IntegrationException(message, e);
		}
		
	}
	
	/**
	 * Obtém conteúdo do Stream da url.
	 * @param url
	 * @return
	 */
	public static String getContentStream(URL url){
		
		try(BufferedReader reader = new BufferedReader(Reader.getInputStream(url))){
			StringBuilder sb = new StringBuilder();
			String str;
			
			while((str = reader.readLine()) != null){
				sb.append(str);
			}
			
			return sb.toString();
		}catch(IOException e){
			String message = MessageConstants.ERRO_LEITURA.getMessage() + url.toString();
			LOGGER.error(message);
			throw new IntegrationException(message, e);
		}
		
	}
	
}
