package br.com.zupacademy.thiago.microserviceproposta.func.viagem_cartao;

import java.net.URI;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.zupacademy.thiago.microserviceproposta.exception.ObjectNotFoundException;
import br.com.zupacademy.thiago.microserviceproposta.model.Cartao;
import br.com.zupacademy.thiago.microserviceproposta.model.Viagem;

@RestController
@RequestMapping("/api/cartoes")
public class ViagemCartaoController {

	@PersistenceContext
	private EntityManager manager;

	@PostMapping("/{id}/viagens")
	@Transactional
	public ResponseEntity<?> criaViagem(@PathVariable String id, @RequestBody @Valid NovaViagemForm form, @RequestHeader("X-Forwarded-For") String clientIp, @RequestHeader("User-Agent") String userAgent) {
		
		Cartao cartao = manager.find(Cartao.class, id);
		if (cartao == null) {
			throw new ObjectNotFoundException("Cartão não encontrado");
		}
		Viagem viagem = form.toModel(cartao, clientIp, userAgent);
		cartao.addViagem(viagem);
		manager.merge(cartao);


		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(viagem.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}
}
