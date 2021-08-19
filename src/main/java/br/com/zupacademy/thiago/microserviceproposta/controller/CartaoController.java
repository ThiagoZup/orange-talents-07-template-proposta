package br.com.zupacademy.thiago.microserviceproposta.controller;

import java.net.URI;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.zupacademy.thiago.microserviceproposta.controller.form.NovaBiometriaForm;
import br.com.zupacademy.thiago.microserviceproposta.exception.ObjectNotFoundException;
import br.com.zupacademy.thiago.microserviceproposta.model.Biometria;
import br.com.zupacademy.thiago.microserviceproposta.model.Cartao;

@RestController
@RequestMapping("/cartoes")
public class CartaoController {

	@PersistenceContext
	private EntityManager manager;

	@PostMapping("/{id}/biometrias")
	@Transactional
	public ResponseEntity<?> criaBiometria(@PathVariable String id, @RequestBody @Valid NovaBiometriaForm form) {
		Cartao cartao = manager.find(Cartao.class, id);
		if(cartao == null) {
			throw new ObjectNotFoundException("Cartão não encontrado");
		}
		Biometria biometria = form.toModel();
		cartao.setBiometria(biometria);
		
		manager.merge(cartao);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(biometria.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}
}
