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
import com.bank.infowayTeste.dtos.AccountDto;
import com.bank.infowayTeste.entities.Account;
import com.bank.infowayTeste.responses.Response;
import com.bank.infowayTeste.services.AccountServices;

@RestController
@RequestMapping("/api/account")
public class AccountManagerController {

	@Autowired
	private AccountServices accountServices;

	@PostMapping(path = "/newAccount")
	public ResponseEntity<Response<Account>> cadastrar(@Valid @RequestBody AccountDto accountDto, BindingResult result) {
		Response<Account> response = new Response<Account>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		Account accountSave = this.accountServices.salvar(accountDto);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(accountDto.getId())
				.toUri();
		response.setData(accountSave);
		return ResponseEntity.created(location).body(response);
	}

    //Retornar todos os valores na minha tabela referente a todos os bancos cadastrados
	@GetMapping(path = "/account")
	public ResponseEntity<List<Account>> listarContas() {
		List<Account> accounts = accountServices.listar();
		return ResponseEntity.status(HttpStatus.OK).body(accounts);
	}

    //Listar o banco selecionado pelo ID cedido na busca
	@GetMapping(path = "/account/{accountClientId}")
	public ResponseEntity<Response<Account>> buscar(@PathVariable("accountClientId") Long id) {
  
		Account account = accountServices.buscar(id);
		Response<Account> response = new Response<Account>();
		response.setData(account);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}

