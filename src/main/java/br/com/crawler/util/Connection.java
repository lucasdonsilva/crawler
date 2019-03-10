package br.com.crawler.util;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import br.com.crawler.constants.MessageConstants;
import br.com.crawler.exception.IntegrationException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static br.com.crawler.constants.MessageConstants.ERRO_CONEXAO;

@Slf4j
class Connection {
	static URLConnection getUrlConnection(URL url){
		try{
			return url.openConnection();
		}catch(IOException e){
			String message = ERRO_CONEXAO.getMessage() + url.toString();
			log.error(message, e);
			throw new IntegrationException(message, e);
		}
	}
}