package com.bank.infowayTeste.dtos;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonFormat;

public class AccountDto implements Serializable {

	private static final long serialVersionUID = -8105241933692707649L;

	private Long id;

	private Long accountAgencyId;
		
	private Double accountBalance;

	private Long accountClientId;

	private Date accountOpenning;

	private Double deposit;

	private Double withdraw;

	public AccountDto() {

	}

	@NotNull(message = "Id da agência é uma informação obrigatória")
	public Long getAccountAgencyId() {
		return accountAgencyId;
	}

	public void setAccountAgencyId(Long accountAgencyId) {
		this.accountAgencyId = accountAgencyId;
	}

	public Double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = (accountBalance + deposit) - withdraw;
	}

	@NotNull(message = "Id do cliente é uma informação obrigatória")
	public Long getAccountClientId() {
		return accountClientId;
	}

	public void setAccountClientId(Long accountClientId) {
		this.accountClientId = accountClientId;
	}

	@NotNull(message = "data de abertura da conta do cliente é uma informação obrigatória")
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
		this.deposit = deposit;
	}

	public Double getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(Double withdraw) {
		this.withdraw = withdraw;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", accountAgencyId=" + accountAgencyId + ", accountBalance=" + accountBalance + ", accountClientId=" + accountClientId + ", accountOpenning=" + accountOpenning + "withdraw=" + withdraw + "deposit=" + deposit + "]";
	}
}