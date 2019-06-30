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
@Table(name = "bank")
public class Bank implements Serializable {

	private static final long serialVersionUID  = -6888542263201514002L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "bank_name", nullable = false)
	private String bankName;
		
	@Column(name = "bank_address", nullable = false)
	private String bankAddress;

	@Column(name = "bank_cnpj", nullable = false)
	private String bankCnpj;

	@Column(name = "bank_phone", nullable = false)
	private String bankPhone;

	@Column(name = "bank_born_city", nullable = false)
	private String bankBornCity;

	@Column(name = "bank_born_state", nullable = false)
	private String bankBornState;		
		
	
	public Bank() {
			
		Hibernate.initialize(getId());

	}

	public Bank(Long id, String bankName, String bankAddress, String bankCnpj, String bankPhone, String bankBornCity, String bankBornState) {

	
		this.id = id;
		this.bankName = bankName;
		this.bankAddress = bankAddress;
		this.bankCnpj = bankCnpj;
		this.bankPhone = bankPhone;
		this.bankBornCity = bankBornCity;
		this.bankBornState = bankBornState;

	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankAddress() {
		return bankAddress;
	}

	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}

	public String getBankCnpj() {
		return bankCnpj;
	}

	public void setBankCnpj(String bankCnpj) {
		this.bankCnpj = bankCnpj;
	}

	public String getBankPhone() {
		return bankPhone;
	}

	public void setBankPhone(String bankPhone) {
		this.bankPhone = bankPhone;
	}

	public String getBankBornCity() {
		return bankBornCity;
	}

	public void setBankBornCity(String bankBornCity) {
		this.bankBornCity = bankBornCity;
	}

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
