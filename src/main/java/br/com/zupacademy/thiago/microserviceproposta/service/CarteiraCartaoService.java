package br.com.zupacademy.thiago.microserviceproposta.service;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.zupacademy.thiago.microserviceproposta.func.carteira_cartao.AssociaCarteiraDto;
import br.com.zupacademy.thiago.microserviceproposta.model.Carteira;

@Service
public class CarteiraCartaoService {

	@PersistenceContext
	private EntityManager manager;

	public ResponseEntity<?> associa(Carteira carteira) {

		RestTemplate restTemplate = new RestTemplate();

		try {
			Map<String, Object> request = Map.of("email", carteira.getEmail(), "carteira", "paypal");
			ResponseEntity<AssociaCarteiraDto> response = restTemplate.postForEntity(
					"http://localhost:8888/api/cartoes/" + carteira.getCartao().getId() + "/carteiras", request,
					AssociaCarteiraDto.class);
			return response;
		} catch (Exception e) {
			return ResponseEntity.unprocessableEntity().build();
		}
	}
}
