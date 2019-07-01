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
	private Long accountAgencyId;

	@Column(name = "account_balance", nullable = true)
	private Double accountBalance;

	@Column(name = "account_client_id", nullable = false)
	private Long accountClientId;

	@JsonSerialize(using = DateSerializer.class)
	@Column(name = "account_openning", nullable = false)
	private Date accountOpenning;

	private Double deposit;

	private Double withdraw;
	
	public Account() {
			
		Hibernate.initialize(getId());

	}

	public Account(Long id, Long accountAgencyId, Double accountBalance, Long accountClientId, Date accountOpenning, Double deposit, Double withdraw) {

	
		this.id = id;
		this.accountAgencyId = accountAgencyId;
		this.accountBalance = accountBalance;
		this.accountClientId = accountClientId;
		this.accountOpenning = accountOpenning;
		this.deposit = deposit;
		this.withdraw = withdraw;

	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAccountAgencyId() {
		return accountAgencyId;
	}

	public void setAccountAgencyId(Long accountAgencyId) {
		this.accountAgencyId = accountAgencyId;
	}

	public Double getAccountBalance() {
		return Math.abs(accountBalance);
	}

	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = (accountBalance + deposit) - withdraw;
	}

	public Long getAccountClientId() {
		return accountClientId;
	}

	public void setAccountClientId(Long accountClientId) {
		this.accountClientId = accountClientId;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	public Date getAccountOpenning() {
		return accountOpenning;
	}

	public void setAccountOpenning(Date accountOpenning) {
		this.accountOpenning = accountOpenning;
	}

	public Double getDeposit() {
		return deposit;
	}

	public void setDeposit(Double deposit) {
		this.deposit = Math.abs(deposit);
	}
	public Double getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(Double withdraw) {
		this.withdraw = Math.abs(withdraw);
	}
	
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", accountAgencyId=" + accountAgencyId + ", accountBalance=" + accountBalance + ", accountClientId=" + accountClientId + ", accountOpenning=" + accountOpenning + "withdraw=" + withdraw + "deposit=" + deposit + "]";
	}

}


