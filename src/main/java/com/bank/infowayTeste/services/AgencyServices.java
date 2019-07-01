package com.bank.infowayTeste.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bank.infowayTeste.dtos.AgencyDto;
import com.bank.infowayTeste.entities.Agency;
import com.bank.infowayTeste.repositories.AgencyRepository;
import com.bank.infowayTeste.services.exceptions.AgencyServiceException;;

@Service
public class AgencyServices {

	@Autowired
	private AgencyRepository agencyRepository;

	public List<Agency> listar() {
		return agencyRepository.findAll();
	}

	public Agency salvar(AgencyDto agencyDto) {

		Agency agency = new Agency();

		agency.setAgencyName(agencyDto.getAgencyName());
		agency.setAgencyAddress(agencyDto.getAgencyAddress());
		agency.setAgencyCnpj(agencyDto.getAgencyCnpj());
		agency.setAgencyPhone(agencyDto.getAgencyPhone());
		agency.setAgencyBornCity(agencyDto.getAgencyBornCity());
		agency.setAgencyBornState(agencyDto.getAgencyBornState());
		agency.setAgencyBankId(agencyDto.getAgencyBankId());
		return agencyRepository.save(agency);
	}

	public Agency buscar(Long id) {
		Agency agency = agencyRepository.getOne(id);

		if (agency == null) {
			throw new AgencyServiceException("Não existe esta agência cadastrada");
		}
		return agency;
	}
}
