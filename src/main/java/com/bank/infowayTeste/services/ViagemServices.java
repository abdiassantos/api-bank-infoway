package com.bank.infowayTeste.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bank.infowayTeste.dtos.ViagemDto;
import com.bank.infowayTeste.entities.Viagem;
import com.bank.infowayTeste.repositories.ViagemRepository;
import com.bank.infowayTeste.services.exceptions.ViagemServiceException;

@Service
public class ViagemServices {

	@Autowired
	private ViagemRepository viagemRepository;

	public List<Viagem> listar() {
		return viagemRepository.findAll();
	}

	public Viagem salvar(ViagemDto viagemDto) {

		Viagem viagem = new Viagem();

		viagem.setLocalDeDestino(viagemDto.getLocalDeDestino());
		viagem.setDataPartida(viagemDto.getDataPartida());
		viagem.setDataRetorno(viagemDto.getDataRetorno());
		viagem.setAcompanhante(viagemDto.getAcompanhante());
		return viagemRepository.save(viagem);
	}

	public Viagem buscar(Long id) {
		Viagem viagem = viagemRepository.getOne(id);

		if (viagem == null) {
			throw new ViagemServiceException("Não existe esta viagem cadastrada");
		}
		return viagem;
	}
}