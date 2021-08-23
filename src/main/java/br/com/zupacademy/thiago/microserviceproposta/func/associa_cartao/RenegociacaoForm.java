package br.com.zupacademy.thiago.microserviceproposta.func.associa_cartao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.zupacademy.thiago.microserviceproposta.model.Cartao;
import br.com.zupacademy.thiago.microserviceproposta.model.Renegociacao;

public class RenegociacaoForm {

	private String id;
	private Integer quantidade;
	private BigDecimal valor;
	private LocalDateTime dataDeCriacao;
	
	public String getId() {
		return id;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public LocalDateTime getDataDeCriacao() {
		return dataDeCriacao;
	}
	
	public Renegociacao toModel(Cartao cartao) {
		return new Renegociacao(id, quantidade, valor, dataDeCriacao, cartao);
	}
}
