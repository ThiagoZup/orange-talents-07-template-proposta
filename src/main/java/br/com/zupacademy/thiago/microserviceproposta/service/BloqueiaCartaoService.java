package br.com.zupacademy.thiago.microserviceproposta.service;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.zupacademy.thiago.microserviceproposta.model.Bloqueio;

@Service
public class BloqueiaCartaoService {

	public void bloqueia(Bloqueio bloqueio) {

		RestTemplate restTemplate = new RestTemplate();
		Map<String, Object> request = Map.of("sistemaResponsavel", bloqueio.getSistemaResponsavel());
		restTemplate.postForEntity("http://localhost:8888/api/cartoes/"+bloqueio.getCartao().getId()+"/bloqueios",
				request, String.class);
	}
}
