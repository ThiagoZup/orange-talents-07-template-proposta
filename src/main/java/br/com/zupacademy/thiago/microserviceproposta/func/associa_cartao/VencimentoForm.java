package br.com.zupacademy.thiago.microserviceproposta.func.associa_cartao;

import java.time.LocalDateTime;

import br.com.zupacademy.thiago.microserviceproposta.model.Cartao;
import br.com.zupacademy.thiago.microserviceproposta.model.Vencimento;

public class VencimentoForm {

	private String id;
	private Integer dia;
	private LocalDateTime dataDeCriacao;
	
	public String getId() {
		return id;
	}
	public Integer getDia() {
		return dia;
	}
	public LocalDateTime getDataDeCriacao() {
		return dataDeCriacao;
	}
	
	public Vencimento toModel(Cartao cartao) {
		return new Vencimento(id, dia, dataDeCriacao, cartao);
	}
}
