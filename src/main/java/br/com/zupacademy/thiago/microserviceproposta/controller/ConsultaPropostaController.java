package br.com.zupacademy.thiago.microserviceproposta.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.thiago.microserviceproposta.controller.dto.ConsultaPropostaDto;
import br.com.zupacademy.thiago.microserviceproposta.exception.ObjectNotFoundException;
import br.com.zupacademy.thiago.microserviceproposta.model.Proposta;
import br.com.zupacademy.thiago.microserviceproposta.repository.PropostaRepository;

@RestController
@RequestMapping("/api/propostas")
public class ConsultaPropostaController {

	@Autowired
	private PropostaRepository repository;

	@GetMapping("/{id}")
	public ResponseEntity<ConsultaPropostaDto> busca(@PathVariable("id") Long id) {

		Optional<Proposta> proposta = repository.findById(id);
		if(proposta.isEmpty()) {
			throw new ObjectNotFoundException("Proposta não encontrada");
		}

		return ResponseEntity.ok().body(new ConsultaPropostaDto(proposta.get()));
	}

}
