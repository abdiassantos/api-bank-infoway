package com.bank.infowayTeste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.infowayTeste.entities.Agency;

@Repository
public interface AgencyRepository extends JpaRepository<Agency, Long> {

	Agency findByAgencyAddress(String agencyAddress);

}
