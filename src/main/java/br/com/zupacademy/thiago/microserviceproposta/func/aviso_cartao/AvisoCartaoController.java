package br.com.zupacademy.thiago.microserviceproposta.func.aviso_cartao;

import java.net.URI;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.zupacademy.thiago.microserviceproposta.exception.ObjectNotFoundException;
import br.com.zupacademy.thiago.microserviceproposta.exception.UnprocessableEntityException;
import br.com.zupacademy.thiago.microserviceproposta.model.Aviso;
import br.com.zupacademy.thiago.microserviceproposta.model.Cartao;
import br.com.zupacademy.thiago.microserviceproposta.service.AvisoCartaoService;

@RestController
@RequestMapping("/api/cartoes")
public class AvisoCartaoController {

	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private TransactionTemplate tx;
	
	@Autowired
	private AvisoCartaoService service;

	@PostMapping("/{id}/avisos")
	public ResponseEntity<?> criaAviso(@PathVariable String id, @RequestBody @Valid NovoAvisoForm form, @RequestHeader("X-Forwarded-For") String clientIp, @RequestHeader("User-Agent") String userAgent) {
		
		Cartao cartao = manager.find(Cartao.class, id);
		if (cartao == null) {
			throw new ObjectNotFoundException("Cartão não encontrado");
		}
		Aviso aviso = form.toModel(cartao, clientIp, userAgent);
		
		ResponseEntity<?> response = service.comunica(aviso);
		
		if (response.getStatusCodeValue() == 200) {
			tx.execute(status -> {
				manager.persist(aviso);
				cartao.addAviso(aviso);
				manager.merge(cartao);
				return null;
			});
		} else {
			throw new UnprocessableEntityException("Não foi possível comunicar aviso");
		}
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(aviso.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}
}
