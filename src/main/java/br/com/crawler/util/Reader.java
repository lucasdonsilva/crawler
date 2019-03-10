package br.com.crawler.util;

import br.com.crawler.exception.IntegrationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import static br.com.crawler.constants.MessageConstants.ERRO_CRIACAO_STREAM;
import static br.com.crawler.constants.MessageConstants.ERRO_LEITURA;
import static br.com.crawler.util.Connection.getUrlConnection;

@Component
@Slf4j
public class Reader {
	
	private static InputStreamReader getInputStream(URL url){
		try{
			return new InputStreamReader(getUrlConnection(url).getInputStream());
		}catch(IOException e){
			String message = ERRO_CRIACAO_STREAM.getMessage() + url.toString();
			log.error(message);
			throw new IntegrationException(message, e);
		}
	}
	
	public static String getContentStream(URL url){
		try(BufferedReader reader = new BufferedReader(getInputStream(url))){
			StringBuilder sb = new StringBuilder();
			String str;
			
			while((str = reader.readLine()) != null) sb.append(str);
			
			return sb.toString();
		}catch(IOException e){
			String message = ERRO_LEITURA.getMessage() + url.toString();
			log.error(message);
			throw new IntegrationException(message, e);
		}
	}
}