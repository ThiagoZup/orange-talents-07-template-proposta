package br.com.zupacademy.thiago.microserviceproposta.service;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.zupacademy.thiago.microserviceproposta.controller.form.SolicitacaoAnaliseForm;
import br.com.zupacademy.thiago.microserviceproposta.exception.UnprocessableEntityException;
import br.com.zupacademy.thiago.microserviceproposta.model.Proposta;
import br.com.zupacademy.thiago.microserviceproposta.model.enums.StatusCartao;
import br.com.zupacademy.thiago.microserviceproposta.model.enums.StatusRetornoSolicitacao;

@Service
public class AnaliseFinanceiraService {

	@PersistenceContext
	private EntityManager manager;

	public void processa(Proposta proposta) {
		RestTemplate restTemplate = new RestTemplate();
		Map<String, Object> request = Map.of("documento", proposta.getDocumento(), "nome", proposta.getNome(),
				"idProposta", proposta.getId());
		try {
			ResponseEntity<SolicitacaoAnaliseForm> response = restTemplate
					.postForEntity("http://localhost:9999/api/solicitacao", request, SolicitacaoAnaliseForm.class);
			SolicitacaoAnaliseForm dto = response.getBody();
			proposta.setStatusCartao(dto.getResultadoSolicitacao().normaliza());
		} catch (Exception e) {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode actualObj;
			try {
				actualObj = mapper.readTree(e.getMessage().substring(7, e.getMessage().length()-1));
				StatusCartao statusCartao = StatusRetornoSolicitacao.valueOf(actualObj.get("resultadoSolicitacao").asText())
						.normaliza();
				proposta.setStatusCartao(statusCartao);
			} catch (Exception e1) {
				throw new UnprocessableEntityException("Não foi possível analisar a proposta");
			}
		}
	}
}
