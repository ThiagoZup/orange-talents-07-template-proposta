package br.com.zupacademy.thiago.microserviceproposta.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Parcela {

	@Id
	private String id;
	private Integer quantidade;
	private BigDecimal valor;
	
	@ManyToOne
	private Cartao cartao;
	
	@Deprecated
	public Parcela() {
	}

	public Parcela(String id, Integer quantidade, BigDecimal valor, Cartao cartao) {
		this.id = id;
		this.quantidade = quantidade;
		this.valor = valor;
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

	public Cartao getCartao() {
		return cartao;
	}
}
