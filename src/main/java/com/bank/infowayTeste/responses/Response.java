package com.bank.infowayTeste.responses;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.bank.infowayTeste.entities.Bank;

public class Response<T> {

	private T data;
	private List<String> errors;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<String> getErrors() {
		if (this.errors == null) {
			this.errors = new ArrayList<String>();
		}
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public Response() {
	}

	public void setData(Optional<Bank> bank) {
		// TODO Auto-generated method stub
		
	}
}
