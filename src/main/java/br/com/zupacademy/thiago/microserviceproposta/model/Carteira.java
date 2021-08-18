package br.com.zupacademy.thiago.microserviceproposta.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Carteira {

	@Id
	private String id;
	private String email;
	private LocalDateTime associadaEm;
	private String emissor;
	
	@ManyToOne
	private Cartao cartao;
	
	@Deprecated
	public Carteira() {
	}

	public Carteira(String id, String email, LocalDateTime associadaEm, String emissor, Cartao cartao) {
		this.id = id;
		this.email = email;
		this.associadaEm = associadaEm;
		this.emissor = emissor;
		this.cartao = cartao;
	}

	public String getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public LocalDateTime getAssociadaEm() {
		return associadaEm;
	}

	public String getEmissor() {
		return emissor;
	}

	public Cartao getCartao() {
		return cartao;
	}
}
