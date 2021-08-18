package br.com.zupacademy.thiago.microserviceproposta.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.zupacademy.thiago.microserviceproposta.controller.form.NovaPropostaForm;
import br.com.zupacademy.thiago.microserviceproposta.model.Proposta;
import br.com.zupacademy.thiago.microserviceproposta.repository.PropostaRepository;
import br.com.zupacademy.thiago.microserviceproposta.service.AnaliseFinanceiraService;

@RestController
@RequestMapping("/propostas")
public class PropostaController {

	@Autowired
	private PropostaRepository repository;

	@Autowired
	private AnaliseFinanceiraService analiseFinanceira;

	@PostMapping
	@Transactional
	public ResponseEntity<?> cria(@RequestBody @Valid NovaPropostaForm form) {

		Proposta proposta = form.toModel(repository);
		repository.save(proposta);

		analiseFinanceira.processa(proposta);
		repository.save(proposta);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(proposta.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

	@GetMapping
	@Transactional
	public ResponseEntity<List<Proposta>> busca() {
		List<Proposta> lista = repository.findAll();

		return ResponseEntity.ok().body(lista);
	}
}
