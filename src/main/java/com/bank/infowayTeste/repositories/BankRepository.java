package com.bank.infowayTeste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.infowayTeste.entities.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {

	Bank findByBankAddress(String bankAddress);

}
