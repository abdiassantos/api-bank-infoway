package com.bank.infowayTeste.dtos;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ClientDto implements Serializable {

	private static final long serialVersionUID = -8105241933692707649L;

	private Long id;

	private String clientName;
		
	private String clientAddress;

	private String clientCpfCnpj;

	private String clientPhone;

	private String clientBornCity;

	private String clientBornState;	
	
	private Long clientAgencyId;

	public ClientDto() {

	}

	@NotNull(message = "Nome do cliente é uma informação obrigatória")
	@Length(min = 5, max = 50, message = "Nome do banco deve estar entre 5 e 50 caracteres")
	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	@NotNull(message = "Endereço do cliente é uma informação obrigatória")
	public String getClientAddress() {
		return clientAddress;
	}

	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}

	@NotNull(message = "CNPJ ou CPF do cliente é uma informação obrigatória")
	public String getClientCpfCnpj() {
		return clientCpfCnpj;
	}

	public void setClientCnpj(String clientCpfCnpj) {
		this.clientCpfCnpj = clientCpfCnpj;
	}

	@NotNull(message = "Telefone do cliente é uma informação obrigatória")
	public String getClientPhone() {
		return clientPhone;
	}

	public void setClientPhone(String clientPhone) {
		this.clientPhone = clientPhone;
	}

	@NotNull(message = "Cidade onde o cliente está situado é uma informação obrigatória")
	public String getClientBornCity() {
		return clientBornCity;
	}

	public void setClientBornCity(String clientBornCity) {
		this.clientBornCity = clientBornCity;
	}

	@NotNull(message = "Estado onde o cliente está situado é uma informação obrigatória")
	public String getClientBornState() {
		return clientBornState;
	}

	public void setBankBornState(String clientBornState) {
		this.clientBornState = clientBornState;
	}

	@NotNull(message = "Agência onde o cliente está situado é uma informação obrigatória")
	public Long getClientAgencyId() {
		return clientAgencyId;
	}

	public void setClientAgencyId(Long clientAgencyId) {
		this.clientAgencyId = clientAgencyId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", clientName=" + clientName + ", clientAddress=" + clientAddress + ", clientCpfCnpj=" + clientCpfCnpj + ", clientPhone=" + clientPhone + ", clientBornCity=" + clientBornCity + ", clientBornState=" + clientBornState + ", clientAgencyId=" + clientAgencyId + "]";
	}
}