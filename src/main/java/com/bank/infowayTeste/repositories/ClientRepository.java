package com.bank.infowayTeste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.infowayTeste.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

	Client findByClientAddress(String clientAddress);

}
