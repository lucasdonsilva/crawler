package br.com.crawler.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MessageConstants {
	
	ERRO_CONEXAO("Erro ao conectar a url: "),
	ERRO_LEITURA("Erro ao ler resultado da url: "),
	ERRO_CRIACAO_STREAM("Erro ao criar um stream da url: ");
	
	public String message;
}
