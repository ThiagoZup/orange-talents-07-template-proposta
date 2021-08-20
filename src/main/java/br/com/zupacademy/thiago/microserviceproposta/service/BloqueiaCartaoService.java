package br.com.zupacademy.thiago.microserviceproposta.service;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.zupacademy.thiago.microserviceproposta.model.Bloqueio;

@Service
public class BloqueiaCartaoService {

	@PersistenceContext
	private EntityManager manager;

	public ResponseEntity<?> bloqueia(Bloqueio bloqueio) {

		RestTemplate restTemplate = new RestTemplate();
		Map<String, Object> request = Map.of("sistemaResponsavel", bloqueio.getSistemaResponsavel());
		ResponseEntity<?> response = restTemplate.postForEntity("http://localhost:8888/api/cartoes/"+bloqueio.getCartao().getId()+"/bloqueios",
				request, String.class);
		return response;
	}
}
