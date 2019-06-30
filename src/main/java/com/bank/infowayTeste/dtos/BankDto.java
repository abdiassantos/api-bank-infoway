package com.bank.infowayTeste.dtos;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonFormat;

public class BankDto implements Serializable {

	private static final long serialVersionUID = -8105241933692707649L;

	private Long id;

	private String bankName;
		
	private String bankAddress;

	private String bankCnpj;

	private String bankPhone;

	private String bankBornCity;

	private String bankBornState;	

	public BankDto() {

	}

	@NotNull(message = "Nome do banco é uma informação obrigatória")
	@Length(min = 5, max = 50, message = "Nome do banco deve estar entre 5 e 50 caracteres")
	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	@NotNull(message = "Endereço do banco é uma informação obrigatória")
	public String getBankAddress() {
		return bankAddress;
	}

	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}

	@NotNull(message = "CNPJ do banco é uma informação obrigatória")
	public String getBankCnpj() {
		return bankCnpj;
	}

	public void setBankCnpj(String bankCnpj) {
		this.bankCnpj = bankCnpj;
	}

	@NotNull(message = "Telefone do banco é uma informação obrigatória")
	public String getBankPhone() {
		return bankPhone;
	}

	public void setBankPhone(String bankPhone) {
		this.bankPhone = bankPhone;
	}

	@NotNull(message = "Cidade onde o banco é situado é uma informação obrigatória")
	public String getBankBornCity() {
		return bankBornCity;
	}

	public void setBankBornCity(String bankBornCity) {
		this.bankBornCity = bankBornCity;
	}

	@NotNull(message = "Estado onde o o banco é situado é uma informação obrigatória")
	public String getBankBornState() {
		return bankBornState;
	}

	public void setBankBornState(String bankBornState) {
		this.bankBornState = bankBornState;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Banco [id=" + id + ", bankName=" + bankName + ", bankAddress=" + bankAddress + ", bankCnpj=" + bankCnpj + ", bankPhone=" + bankPhone + ", bankBornCity=" + bankBornCity + ", bankBornState=" + bankBornState + "]";
	}
}