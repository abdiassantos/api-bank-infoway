package com.bank.infowayTeste.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Component
@Table(name = "client")
public class Client implements Serializable {

	private static final long serialVersionUID  = -6888542263201514002L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "client_name", nullable = false)
	private String clientName;
		
	@Column(name = "client_address", nullable = false)
	private String clientAddress;

	@Column(name = "client_cpfCnpj", nullable = false)
	private String clientCpfCnpj;

	@Column(name = "client_phone", nullable = false)
	private String clientPhone;

	@Column(name = "client_born_city", nullable = false)
	private String clientBornCity;

	@Column(name = "client_born_state", nullable = false)
	private String clientBornState;		

	@Column(name = "client_agency_id", nullable = false)
	private Long clientAgencyId;
	
	public Client() {
			
		Hibernate.initialize(getId());

	}

	public Client(Long id, String clientName, String clientAddress, String clientCpfCnpj, String clientPhone, String clientBornCity, String clientBornState, Long clientAgencyId) {

	
		this.id = id;
		this.clientName = clientName;
		this.clientAddress = clientAddress;
		this.clientCpfCnpj = clientCpfCnpj;
		this.clientPhone = clientPhone;
		this.clientBornCity = clientBornCity;
		this.clientBornState = clientBornState;
		this.clientAgencyId = clientAgencyId;

	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientAddress() {
		return clientAddress;
	}

	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}

	public String getClientCpfCnpj() {
		return clientCpfCnpj;
	}

	public void setClientCpfCnpj(String clientCpfCnpj) {
		this.clientCpfCnpj = clientCpfCnpj;
	}

	public String getClientPhone() {
		return clientPhone;
	}

	public void setClientPhone(String clientPhone) {
		this.clientPhone = clientPhone;
	}

	public String getClientBornCity() {
		return clientBornCity;
	}

	public void setClientBornCity(String clientBornCity) {
		this.clientBornCity = clientBornCity;
	}

	public String getClientBornState() {
		return clientBornState;
	}

	public void setClientBornState(String clientBornState) {
		this.clientBornState = clientBornState;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getClientAgencyId() {
		return clientAgencyId;
	}

	public void setClientAgencyId(Long clientAgencyId) {
		this.clientAgencyId = clientAgencyId;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", clientName=" + clientName + ", clientAddress=" + clientAddress + ", clientCpfCnpj=" + clientCpfCnpj + ", clientPhone=" + clientPhone + ", clientBornCity=" + clientBornCity + ", clientBornState=" + clientBornState + ", clientAgencyId=" + clientAgencyId + "]";
	}

}


