package com.bank.infowayTeste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bank.infowayTeste.entities.Viagem;

@Repository
public interface ViagemRepository extends JpaRepository<Viagem, Long> {

	Viagem findByLocalDeDestino(String localDeDestino);

}
