package com.bank.infowayTeste.dtos;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonFormat;

public class AgencyDto implements Serializable {

	private static final long serialVersionUID = -8105241933692707649L;

	private Long id;

	private String agencyName;
		
	private String agencyAddress;

	private String agencyCnpj;

	private String agencyPhone;

	private String agencyBornCity;

	private String agencyBornState;	
	
	private Long agencyBankId;

	public AgencyDto() {

	}

	@NotNull(message = "Nome da agência é uma informação obrigatória")
	@Length(min = 5, max = 50, message = "Nome do banco deve estar entre 5 e 50 caracteres")
	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	@NotNull(message = "Endereço da agência é uma informação obrigatória")
	public String getAgencyAddress() {
		return agencyAddress;
	}

	public void setAgencyAddress(String agencyAddress) {
		this.agencyAddress = agencyAddress;
	}

	@NotNull(message = "CNPJ da agência é uma informação obrigatória")
	public String getAgencyCnpj() {
		return agencyCnpj;
	}

	public void setAgencyCnpj(String agencyCnpj) {
		this.agencyCnpj = agencyCnpj;
	}

	@NotNull(message = "Telefone da agência é uma informação obrigatória")
	public String getAgencyPhone() {
		return agencyPhone;
	}

	public void setAgencyPhone(String agencyPhone) {
		this.agencyPhone = agencyPhone;
	}

	@NotNull(message = "Cidade onde a agência é situada é uma informação obrigatória")
	public String getAgencyBornCity() {
		return agencyBornCity;
	}

	public void setAgencyBornCity(String agencyBornCity) {
		this.agencyBornCity = agencyBornCity;
	}

	@NotNull(message = "Estado onde a agência é situada é uma informação obrigatória")
	public String getAgencyBornState() {
		return agencyBornState;
	}

	public void setBankBornState(String agencyBornState) {
		this.agencyBornState = agencyBornState;
	}

	@NotNull(message = "Banco onde a agência é situada é uma informação obrigatória")
	public Long getAgencyBankId() {
		return agencyBankId;
	}

	public void setAgencyBankId(Long agencyBankId) {
		this.agencyBankId = agencyBankId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Agência [id=" + id + ", agencyName=" + agencyName + ", agencyAddress=" + agencyAddress + ", agencyCnpj=" + agencyCnpj + ", agencyPhone=" + agencyPhone + ", agencyBornCity=" + agencyBornCity + ", agencyBornState=" + agencyBornState + ", agencyBankId=" + agencyBankId + "]";
	}
}