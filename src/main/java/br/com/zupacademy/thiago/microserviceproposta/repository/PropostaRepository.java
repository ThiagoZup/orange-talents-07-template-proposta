package br.com.zupacademy.thiago.microserviceproposta.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.thiago.microserviceproposta.model.Cartao;
import br.com.zupacademy.thiago.microserviceproposta.model.Proposta;
import br.com.zupacademy.thiago.microserviceproposta.model.enums.StatusProposta;

public interface PropostaRepository extends JpaRepository<Proposta, Long> {

	Optional<Proposta> findByDocumentoHash(String documentoHash);
	
	List<Proposta> findFirst10ByStatusCartaoAndCartao(StatusProposta statusCartao, Cartao cartao);
}
