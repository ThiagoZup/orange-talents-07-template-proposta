package br.com.zupacademy.thiago.microserviceproposta.service;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.zupacademy.thiago.microserviceproposta.model.Aviso;

@Service
public class AvisoCartaoService {

	@PersistenceContext
	private EntityManager manager;

	public ResponseEntity<?> comunica(Aviso aviso) {

		RestTemplate restTemplate = new RestTemplate();
		
		try {
			Map<String, Object> request = Map.of("destino", aviso.getDestino(), "validoAte", aviso.getValidoAte());
			ResponseEntity<?> response = restTemplate.postForEntity("http://localhost:8888/api/cartoes/"+aviso.getCartao().getId()+"/avisos",
					request, String.class);
			return response;
		} catch (Exception e) {
			System.out.println(e.getCause());
			return ResponseEntity.unprocessableEntity().build();
		}
	}
}
