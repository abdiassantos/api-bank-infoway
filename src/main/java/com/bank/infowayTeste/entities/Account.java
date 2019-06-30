package com.bank.infowayTeste.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Component
@Table(name = "account")
public class Account implements Serializable {

	private static final long serialVersionUID  = -6888542263201514002L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
		
	@Column(name = "account_agency_id", nullable = false)
	private String accountAgencyId;

	@Column(name = "account_balance", nullable = true)
	private Double accountBalance;

	@Column(name = "account_client_id", nullable = false)
	private String accountClientId;

	@JsonSerialize(using = DateSerializer.class)
	@Column(name = "account_openning", nullable = false)
	private Date accountOpenning;
	
	public Account() {
			
		Hibernate.initialize(getId());

	}

	public Account(Long id, String accountAgencyId, Double accountBalance, String accountClientId, Date accountOpenning) {

	
		this.id = id;
		this.accountAgencyId = accountAgencyId;
		this.accountBalance = accountBalance;
		this.accountClientId = accountClientId;
		this.accountOpenning = accountOpenning;

	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountAgencyId() {
		return accountAgencyId;
	}

	public void setAccountAgencyId(String accountAgencyId) {
		this.accountAgencyId = accountAgencyId;
	}

	public Double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getAccountClientId() {
		return accountClientId;
	}

	public void setAccountClientId(String accountClientId) {
		this.accountClientId = accountClientId;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	public Date getAccountOpenning() {
		return accountOpenning;
	}

	public void setAccountOpenning(Date accountOpenning) {
		this.accountOpenning = accountOpenning;
	}

	
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", accountAgencyId=" + accountAgencyId + ", accountBalance=" + accountBalance + ", accountClientId=" + accountClientId + ", accountOpenning=" + accountOpenning +  "]";
	}

}


