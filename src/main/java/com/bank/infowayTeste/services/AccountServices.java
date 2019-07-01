package com.bank.infowayTeste.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bank.infowayTeste.dtos.AccountDto;
import com.bank.infowayTeste.entities.Account;
import com.bank.infowayTeste.repositories.AccountRepository;
import com.bank.infowayTeste.services.exceptions.AccountServiceException;;

@Service
public class AccountServices {

	@Autowired
	private AccountRepository accountRepository;

	public List<Account> listar() {
		return accountRepository.findAll();
	}

	public Account salvar(AccountDto accountDto) {

		Account account = new Account();

		account.setAccountAgencyId(accountDto.getAccountAgencyId());
		account.setAccountBalance(accountDto.getAccountBalance());
		account.setAccountClientId(accountDto.getAccountClientId());
		account.setAccountOpenning(accountDto.getAccountOpenning());
		account.setDeposit(accountDto.getDeposit());
		account.setWithdraw(accountDto.getWithdraw());
		return accountRepository.save(account);
	}

	public Account buscar(Long id) {

		Account accountGetClientId = new Account();

		Account account = accountRepository.getOne(accountGetClientId.getAccountClientId());

		if (account == null) {
			throw new AccountServiceException("Não existe esta conta cadastrada");
		}
		return account;
	}
}
