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
import com.bank.infowayTeste.dtos.AgencyDto;
import com.bank.infowayTeste.entities.Agency;
import com.bank.infowayTeste.responses.Response;
import com.bank.infowayTeste.services.AgencyServices;

@RestController
@RequestMapping("/api/agency")
public class AgencyManagerController {

	@Autowired
	private AgencyServices agencyServices;

	@PostMapping(path = "/newAgency")
	public ResponseEntity<Response<Agency>> cadastrar(@Valid @RequestBody AgencyDto agencyDto, BindingResult result) {
		Response<Agency> response = new Response<Agency>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		Agency agencySave = this.agencyServices.salvar(agencyDto);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(agencyDto.getId())
				.toUri();
		response.setData(agencySave);
		return ResponseEntity.created(location).body(response);
	}

    //Retornar todos os valores na minha tabela referente a todos os bancos cadastrados
	@GetMapping(path = "/agency")
	public ResponseEntity<List<Agency>> listarAgencia() {
		List<Agency> agencies = agencyServices.listar();
		return ResponseEntity.status(HttpStatus.OK).body(agencies);
	}

    //Listar o banco selecionado pelo ID cedido na busca
	@GetMapping(path = "/agency/{id}")
	public ResponseEntity<Response<Agency>> buscar(@PathVariable("id") Long id) {
  
		Agency agency = agencyServices.buscar(id);
		Response<Agency> response = new Response<Agency>();
		response.setData(agency);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}

