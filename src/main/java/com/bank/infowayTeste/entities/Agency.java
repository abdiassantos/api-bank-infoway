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
@Table(name = "agency")
public class Agency implements Serializable {

	private static final long serialVersionUID  = -6888542263201514002L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "agency_name", nullable = false)
	private String agencyName;
		
	@Column(name = "agency_address", nullable = false)
	private String agencyAddress;

	@Column(name = "agency_cnpj", nullable = false)
	private String agencyCnpj;

	@Column(name = "agency_phone", nullable = false)
	private String agencyPhone;

	@Column(name = "agency_born_city", nullable = false)
	private String agencyBornCity;

	@Column(name = "agency_born_state", nullable = false)
	private String agencyBornState;		

	@Column(name = "agency_bank_id", nullable = false)
	private Long agencyBankId;
	
	public Agency() {
			
		Hibernate.initialize(getId());

	}

	public Agency(Long id, String agencyName, String agencyAddress, String agencyCnpj, String agencyPhone, String agencyBornCity, String agencyBornState, Long agencyBankId) {

	
		this.id = id;
		this.agencyName = agencyName;
		this.agencyAddress = agencyAddress;
		this.agencyCnpj = agencyCnpj;
		this.agencyPhone = agencyPhone;
		this.agencyBornCity = agencyBornCity;
		this.agencyBornState = agencyBornState;
		this.agencyBankId = agencyBankId;

	}

	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	public String getAgencyAddress() {
		return agencyAddress;
	}

	public void setAgencyAddress(String agencyAddress) {
		this.agencyAddress = agencyAddress;
	}

	public String getAgencyCnpj() {
		return agencyCnpj;
	}

	public void setAgencyCnpj(String agencyCnpj) {
		this.agencyCnpj = agencyCnpj;
	}

	public String getAgencyPhone() {
		return agencyPhone;
	}

	public void setAgencyPhone(String agencyPhone) {
		this.agencyPhone = agencyPhone;
	}

	public String getAgencyBornCity() {
		return agencyBornCity;
	}

	public void setAgencyBornCity(String agencyBornCity) {
		this.agencyBornCity = agencyBornCity;
	}

	public String getAgencyBornState() {
		return agencyBornState;
	}

	public void setAgencyBornState(String agencyBornState) {
		this.agencyBornState = agencyBornState;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAgencyBankId() {
		return agencyBankId;
	}

	public void setAgencyBankId(Long agencyBankId) {
		this.agencyBankId = agencyBankId;
	}

	@Override
	public String toString() {
		return "Agência [id=" + id + ", agencyName=" + agencyName + ", agencyAddress=" + agencyAddress + ", agencyCnpj=" + agencyCnpj + ", agencyPhone=" + agencyPhone + ", agencyBornCity=" + agencyBornCity + ", agencyBornState=" + agencyBornState + ", agencyBankId=" + agencyBankId + "]";
	}

}

