package com.bank.infowayTeste.services.exceptions;

public class BankServiceException extends RuntimeException {

	private static final long serialVersionUID = -1402677565107062800L;

	public BankServiceException(String mensagem) {
		super(mensagem);
	}

	public BankServiceException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}