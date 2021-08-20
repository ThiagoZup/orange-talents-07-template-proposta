package br.com.zupacademy.thiago.microserviceproposta.service;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.zupacademy.thiago.microserviceproposta.controller.form.NovoCartaoForm;
import br.com.zupacademy.thiago.microserviceproposta.model.Cartao;
import br.com.zupacademy.thiago.microserviceproposta.model.Proposta;
import br.com.zupacademy.thiago.microserviceproposta.model.enums.StatusProposta;
import br.com.zupacademy.thiago.microserviceproposta.repository.PropostaRepository;

@Service
public class VinculoCartaoService {

	@PersistenceContext
	private EntityManager manager;

	@Autowired
	private PropostaRepository propostaRepository;

	@Scheduled(fixedDelay = 5000)
	@Transactional
	public void vinculaCartoes() {
		List<Proposta> propostas = propostaRepository.findFirst10ByStatusCartaoAndCartao(StatusProposta.ELEGIVEL, null);
		if (propostas.size() > 0) {
			for (Proposta proposta : propostas) {
				processa(proposta);
			}
		} //else {System.out.println("teste");}
	}

	private void processa(Proposta proposta) {
		RestTemplate restTemplate = new RestTemplate();
		Map<String, Object> request = Map.of("documento", proposta.getDocumento(), "nome", proposta.getNome(),
				"idProposta", proposta.getId());

		ResponseEntity<NovoCartaoForm> response = restTemplate.postForEntity("http://localhost:8888/api/cartoes",
				request, NovoCartaoForm.class);
		if (response.getStatusCode() == HttpStatus.CREATED) {
			Cartao cartao = new Cartao(response.getBody(), propostaRepository);
			manager.persist(cartao);
			proposta.setCartao(cartao);
			manager.merge(proposta);
			//System.out.println(response.getStatusCodeValue());
		}
	} 
}
