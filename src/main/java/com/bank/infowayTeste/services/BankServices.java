package com.bank.infowayTeste.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bank.infowayTeste.dtos.BankDto;
import com.bank.infowayTeste.entities.Bank;
import com.bank.infowayTeste.repositories.BankRepository;
import com.bank.infowayTeste.services.exceptions.BankServiceException;;

@Service
public class BankServices {

	@Autowired
	private BankRepository bankRepository;

	public List<Bank> listar() {
		return bankRepository.findAll();
	}

	public Bank salvar(BankDto bankDto) {

		Bank bank = new Bank();

		bank.setBankName(bankDto.getBankName());
		bank.setBankAddress(bankDto.getBankAddress());
		bank.setBankCnpj(bankDto.getBankCnpj());
		bank.setBankPhone(bankDto.getBankPhone());
		bank.setBankBornCity(bankDto.getBankBornCity());
		bank.setBankBornState(bankDto.getBankBornState());
		return bankRepository.save(bank);
	}

	public Bank buscar(Long id) {
		Bank bank = bankRepository.getOne(id);

		if (bank == null) {
			throw new BankServiceException("Não existe este banco cadastrado");
		}
		return bank;
	}
}
