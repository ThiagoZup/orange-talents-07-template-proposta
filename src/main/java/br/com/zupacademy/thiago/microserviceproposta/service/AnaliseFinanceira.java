package br.com.zupacademy.thiago.microserviceproposta.service;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.zupacademy.thiago.microserviceproposta.controller.dto.SolicitacaoAnaliseDto;
import br.com.zupacademy.thiago.microserviceproposta.model.Proposta;

@Service
public class AnaliseFinanceira {
	
	@PersistenceContext
	private EntityManager manager;

	public void processa(Proposta proposta) {
		RestTemplate restTemplate = new RestTemplate();
		Map<String, Object> request = Map.of("documento", proposta.getDocumento(), "nome", proposta.getNome(), "idProposta", proposta.getId());
		ResponseEntity<SolicitacaoAnaliseDto> response = restTemplate.postForEntity("http://localhost:9999/api/solicitacao", request, SolicitacaoAnaliseDto.class);
		SolicitacaoAnaliseDto dto = response.getBody();
		proposta.setResultadoSolicitacao(dto.getResultadoSolicitacao());
		
		//manager.merge(proposta);
	}
}
