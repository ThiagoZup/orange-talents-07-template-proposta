package br.com.zupacademy.thiago.microserviceproposta.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Bloqueio {

	@Id
	@Column(unique = true)
	private String id;
	private LocalDateTime bloqueadoEm;
	private String sistemaResponsavel;
	private boolean ativo;
	
	@ManyToOne
	private Cartao cartao;
	
	@Deprecated
	public Bloqueio() {
	}

	public Bloqueio(String id, LocalDateTime bloqueadoEm, String sistemaResponsavel, boolean ativo, Cartao cartao) {
		this.id = id;
		this.bloqueadoEm = bloqueadoEm;
		this.sistemaResponsavel = sistemaResponsavel;
		this.ativo = ativo;
		this.cartao = cartao;
	}

	public String getId() {
		return id;
	}

	public LocalDateTime getBloqueadoEm() {
		return bloqueadoEm;
	}

	public String getSistemaResponsavel() {
		return sistemaResponsavel;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public Cartao getCartao() {
		return cartao;
	}
	
}
