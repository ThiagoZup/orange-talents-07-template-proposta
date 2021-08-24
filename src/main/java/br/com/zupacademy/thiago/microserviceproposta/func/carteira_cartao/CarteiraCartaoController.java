package br.com.zupacademy.thiago.microserviceproposta.func.carteira_cartao;

import java.net.URI;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

import br.com.zupacademy.thiago.microserviceproposta.exception.ObjectNotFoundException;
import br.com.zupacademy.thiago.microserviceproposta.exception.UnprocessableEntityException;
import br.com.zupacademy.thiago.microserviceproposta.model.Cartao;
import br.com.zupacademy.thiago.microserviceproposta.model.Carteira;
import br.com.zupacademy.thiago.microserviceproposta.repository.CarteiraRepository;
import br.com.zupacademy.thiago.microserviceproposta.service.CarteiraCartaoService;

@RestController
@RequestMapping("/api/cartoes")
public class CarteiraCartaoController {

	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private CarteiraRepository carteiraRepository;
	
	@Autowired
	private TransactionTemplate tx;
	
	@Autowired
	private CarteiraCartaoService service;

	@PostMapping("/{id}/carteiras")
	public ResponseEntity<?> criaCarteira(@PathVariable String id, @RequestBody @Valid NovaCarteiraForm form) {
		
		Cartao cartao = manager.find(Cartao.class, id);
		if (cartao == null) {
			throw new ObjectNotFoundException("Cartão não encontrado");
		}
		
		Optional<Carteira> optional = carteiraRepository.findByCartaoAndEmissor(cartao, form.getEmissor());
		if(optional.isPresent()) {
			throw new UnprocessableEntityException("Cartão já possui carteira desse emissor");
		}
		Carteira carteira = form.toModel(cartao);
		
		ResponseEntity<?> response = service.associa(carteira);
		
		if (response.getStatusCodeValue() == 200) {
			AssociaCarteiraDto responseBody = (AssociaCarteiraDto) response.getBody();
			carteira.setIdLegado(responseBody.getId());
			tx.execute(status -> {
				manager.persist(carteira);
				return null;
			});
		} else {
			throw new UnprocessableEntityException("Não foi possível associar carteira");
		}
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(carteira.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}
}
