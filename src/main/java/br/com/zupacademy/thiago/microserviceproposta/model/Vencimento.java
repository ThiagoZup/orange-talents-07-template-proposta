package br.com.zupacademy.thiago.microserviceproposta.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Vencimento {

	@Id
	private String id;
	private Integer dia;
	private LocalDateTime dataDeCriacao;
	
	@OneToOne
	private Cartao cartao;
	
	@Deprecated
	public Vencimento() {
	}

	public Vencimento(String id, Integer dia, LocalDateTime dataDeCriacao, Cartao cartao) {
		this.id = id;
		this.dia = dia;
		this.dataDeCriacao = dataDeCriacao;
		this.cartao = cartao;
	}

	public String getId() {
		return id;
	}

	public Integer getDia() {
		return dia;
	}

	public LocalDateTime getDataDeCriacao() {
		return dataDeCriacao;
	}

	public Cartao getCartao() {
		return cartao;
	}
}
