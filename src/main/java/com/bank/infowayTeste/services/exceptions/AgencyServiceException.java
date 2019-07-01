package com.bank.infowayTeste.services.exceptions;

public class AgencyServiceException extends RuntimeException {

	private static final long serialVersionUID = -1402677565107062800L;

	public AgencyServiceException(String mensagem) {
		super(mensagem);
	}

	public AgencyServiceException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}