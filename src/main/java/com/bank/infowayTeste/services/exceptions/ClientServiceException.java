package com.bank.infowayTeste.services.exceptions;

public class ClientServiceException extends RuntimeException {

	private static final long serialVersionUID = -1402677565107062800L;

	public ClientServiceException(String mensagem) {
		super(mensagem);
	}

	public ClientServiceException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}