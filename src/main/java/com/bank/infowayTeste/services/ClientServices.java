package com.bank.infowayTeste.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bank.infowayTeste.dtos.ClientDto;
import com.bank.infowayTeste.entities.Client;
import com.bank.infowayTeste.repositories.ClientRepository;
import com.bank.infowayTeste.services.exceptions.ClientServiceException;;

@Service
public class ClientServices {

	@Autowired
	private ClientRepository clientRepository;

	public List<Client> listar() {
		return clientRepository.findAll();
	}

	public Client salvar(ClientDto clientDto) {

		Client client = new Client();

		client.setClientName(clientDto.getClientName());
		client.setClientAddress(clientDto.getClientAddress());
		client.setClientCpfCnpj(clientDto.getClientCpfCnpj());
		client.setClientPhone(clientDto.getClientPhone());
		client.setClientBornCity(clientDto.getClientBornCity());
		client.setClientBornState(clientDto.getClientBornState());
		client.setClientAgencyId(clientDto.getClientAgencyId());
		return clientRepository.save(client);
	}

	public Client buscar(Long id) {
		Client client = clientRepository.getOne(id);

		if (client == null) {
			throw new ClientServiceException("Não existe este cliente cadastrado");
		}
		return client;
	}
}
