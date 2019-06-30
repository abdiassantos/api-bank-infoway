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
import com.bank.infowayTeste.dtos.BankDto;
import com.bank.infowayTeste.entities.Bank;
import com.bank.infowayTeste.responses.Response;
import com.bank.infowayTeste.services.BankServices;

@RestController
@RequestMapping("/api/viagem")
public class BankManagerController {

	@Autowired
    private BankServices bankServices;

	@PostMapping(path = "/newBank")
	public ResponseEntity<Response<Bank>> cadastrar(@Valid @RequestBody BankDto bankDto, BindingResult result) {
		Response<Bank> response = new Response<Bank>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		Bank bankSave = this.bankServices.salvar(bankDto);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(bankDto.getId())
				.toUri();
		response.setData(bankSave);
		return ResponseEntity.created(location).body(response);
	}

    //Retornar todos os valores na minha tabela referente a todos os bancos cadastrados
	@GetMapping(path = "/bank")
	public ResponseEntity<List<Bank>> listarBanco() {
		List<Bank> banks = bankServices.listar();
		return ResponseEntity.status(HttpStatus.OK).body(banks);
	}

    //Listar o banco selecionado pelo ID cedido na busca
	@GetMapping(path = "/bank/{id}")
	public ResponseEntity<Response<Bank>> buscar(@PathVariable("id") Long id) {
  
		Bank bank = bankServices.buscar(id);
		Response<Bank> response = new Response<Bank>();
		response.setData(bank);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}

