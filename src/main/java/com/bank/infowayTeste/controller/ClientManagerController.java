package com.bank.infowayTeste.controller;

import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.bank.infowayTeste.dtos.ClientDto;
import com.bank.infowayTeste.entities.Client;
import com.bank.infowayTeste.responses.Response;
import com.bank.infowayTeste.services.ClientServices;

@RestController
@RequestMapping("/api/client")
public class ClientManagerController {

	@Autowired
	private ClientServices clientServices;

	@PostMapping(path = "/newClient")
	public ResponseEntity<Response<Client>> cadastrar(@Valid @RequestBody ClientDto clientDto, BindingResult result) {
		Response<Client> response = new Response<Client>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		Client clientSave = this.clientServices.salvar(clientDto);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(clientDto.getId())
				.toUri();
		response.setData(clientSave);
		return ResponseEntity.created(location).body(response);
	}

    //Retornar todos os valores na minha tabela referente a todos os bancos cadastrados
	@GetMapping(path = "/client")
	public ResponseEntity<List<Client>> listarCliente() {
		List<Client> clients = clientServices.listar();
		return ResponseEntity.status(HttpStatus.OK).body(clients);
	}

    //Listar o banco selecionado pelo ID cedido na busca
	@GetMapping(path = "/client/{id}")
	public ResponseEntity<Response<Client>> buscar(@PathVariable("id") Long id) {
  
		Client client = clientServices.buscar(id);
		Response<Client> response = new Response<Client>();
		response.setData(client);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}

