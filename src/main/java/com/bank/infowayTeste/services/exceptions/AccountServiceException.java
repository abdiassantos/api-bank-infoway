package com.bank.infowayTeste.services.exceptions;

public class AccountServiceException extends RuntimeException {

	private static final long serialVersionUID = -1402677565107062800L;

	public AccountServiceException(String mensagem) {
		super(mensagem);
	}

	public AccountServiceException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}