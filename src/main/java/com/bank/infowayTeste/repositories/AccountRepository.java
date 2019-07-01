package com.bank.infowayTeste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.infowayTeste.entities.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
