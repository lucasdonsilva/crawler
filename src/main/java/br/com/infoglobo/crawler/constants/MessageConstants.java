package br.com.infoglobo.crawler.constants;

public enum MessageConstants {
	
	ERRO_CONEXAO("Erro ao conectar a url: "),
	ERRO_LEITURA("Erro ao ler resultado da url: "),
	ERRO_CRIACAO_STREAM("Erro ao criar um stream da url: ");
	
	public String message;

	public String getMessage() {
		return message;
	}

	MessageConstants(String value) {
		this.message = value;
	}

}
