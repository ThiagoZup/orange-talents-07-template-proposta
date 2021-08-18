package br.com.zupacademy.thiago.microserviceproposta.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Renegociacao {

	@Id
	private String id;
	private Integer quantidade;
	private BigDecimal valor;
	private LocalDateTime dataDeCriacao;
	
	@OneToOne
	private Cartao cartao;
	
	@Deprecated
	public Renegociacao() {
	}

	public Renegociacao(String id, Integer quantidade, BigDecimal valor, LocalDateTime dataDeCriacao, Cartao cartao) {
		this.id = id;
		this.quantidade = quantidade;
		this.valor = valor;
		this.dataDeCriacao = dataDeCriacao;
		this.cartao = cartao;
	}

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

	public Cartao getCartao() {
		return cartao;
	}
}
