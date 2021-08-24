package br.com.zupacademy.thiago.microserviceproposta.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.thiago.microserviceproposta.model.Cartao;
import br.com.zupacademy.thiago.microserviceproposta.model.Carteira;
import br.com.zupacademy.thiago.microserviceproposta.model.enums.EmissoresCarteira;

public interface CarteiraRepository extends JpaRepository<Carteira, Long> {

	Optional<Carteira> findByCartaoAndEmissor(Cartao cartao, EmissoresCarteira emissor);

}
