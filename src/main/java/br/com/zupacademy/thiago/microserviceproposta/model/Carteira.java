package br.com.zupacademy.thiago.microserviceproposta.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.zupacademy.thiago.microserviceproposta.model.enums.EmissoresCarteira;

@Entity
public class Carteira {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	@Column(unique=true)
	private String idLegado;
	private String email;
	private LocalDateTime associadaEm = LocalDateTime.now();
	
	@Enumerated(EnumType.STRING)
	private EmissoresCarteira emissor;
	
	@ManyToOne
	private Cartao cartao;
	
	@Deprecated
	public Carteira() {
	}

	public Carteira(String idLegado, String email, LocalDateTime associadaEm, EmissoresCarteira emissor, Cartao cartao) {
		this.idLegado = idLegado;
		this.email = email;
		this.associadaEm = associadaEm;
		this.emissor = emissor;
		this.cartao = cartao;
	}
	
	public Carteira(String email, EmissoresCarteira emissor, Cartao cartao) {
		this.email = email;
		this.emissor = emissor;
		this.cartao = cartao;
	}

	public String getId() {
		return id;
	}

	public String getIdLegado() {
		return idLegado;
	}

	public void setIdLegado(String idLegado) {
		this.idLegado = idLegado;
	}

	public String getEmail() {
		return email;
	}

	public LocalDateTime getAssociadaEm() {
		return associadaEm;
	}

	public EmissoresCarteira getEmissor() {
		return emissor;
	}

	public Cartao getCartao() {
		return cartao;
	}
}
