package br.com.zupacademy.thiago.microserviceproposta.controller;

import java.net.URI;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.zupacademy.thiago.microserviceproposta.controller.form.NovaBiometriaForm;
import br.com.zupacademy.thiago.microserviceproposta.controller.form.NovoBloqueioForm;
import br.com.zupacademy.thiago.microserviceproposta.exception.ObjectNotFoundException;
import br.com.zupacademy.thiago.microserviceproposta.exception.UnprocessableEntityException;
import br.com.zupacademy.thiago.microserviceproposta.model.Biometria;
import br.com.zupacademy.thiago.microserviceproposta.model.Bloqueio;
import br.com.zupacademy.thiago.microserviceproposta.model.Cartao;
import br.com.zupacademy.thiago.microserviceproposta.model.enums.StatusCartao;
import br.com.zupacademy.thiago.microserviceproposta.service.BloqueiaCartaoService;

@RestController
@RequestMapping("/api/cartoes")
public class CartaoController {

	@Autowired
	private TransactionTemplate tx;

	@Autowired
	private BloqueiaCartaoService bloqueiaCartaoService;

	@PersistenceContext
	private EntityManager manager;

	@PostMapping("/{id}/biometrias")
	@Transactional
	public ResponseEntity<?> criaBiometria(@PathVariable String id, @RequestBody @Valid NovaBiometriaForm form) {

		Cartao cartao = manager.find(Cartao.class, id);
		if (cartao == null) {
			throw new ObjectNotFoundException("Cartão não encontrado");
		}
		Biometria biometria = form.toModel();

		cartao.setBiometria(biometria);
		manager.merge(cartao);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(biometria.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

	@PostMapping("/{id}/bloqueios")
	public ResponseEntity<?> criaBloqueio(@PathVariable String id, @RequestBody @Valid NovoBloqueioForm form) {

		Cartao cartao = manager.find(Cartao.class, id);
		if (cartao == null) {
			throw new ObjectNotFoundException("Cartão não encontrado");
		}
		if (cartao.getBloqueios().size() > 0) {
			for (Bloqueio bloqueio : cartao.getBloqueios()) {
				if (bloqueio.isAtivo())
					throw new UnprocessableEntityException("Cartão já bloqueado");
			}
		}
		Bloqueio bloqueio = form.toModel(cartao);
		cartao.addBloqueio(bloqueio);

		ResponseEntity<?> response = bloqueiaCartaoService.bloqueia(bloqueio);
		System.out.println(response.getStatusCodeValue());
		
		if (response.getStatusCodeValue() == 200) {
			cartao.setStatus(StatusCartao.BLOQUEADO);
			tx.execute(status -> {
				manager.merge(cartao);
				return null;
			});
		} else {
			throw new UnprocessableEntityException("Não foi possível atualizar estado do cartão");
		}

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(bloqueio.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}
}
