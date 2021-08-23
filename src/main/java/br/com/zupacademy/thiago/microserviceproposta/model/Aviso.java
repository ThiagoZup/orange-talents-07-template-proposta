package br.com.zupacademy.thiago.microserviceproposta.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Aviso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate validoAte;
	private String destino;
	private String userAgent;
	private String clientIp;
	
	@ManyToOne
	private Cartao cartao;
	
	@Deprecated
	public Aviso() {
	}

	public Aviso(LocalDate validoAte, String destino, Cartao cartao) {
		this.validoAte = validoAte;
		this.destino = destino;
		this.cartao = cartao;
	}

	public Aviso(LocalDate validoAte, String destino, String userAgent, String clientIp, Cartao cartao) {
		super();
		this.validoAte = validoAte;
		this.destino = destino;
		this.userAgent = userAgent;
		this.clientIp = clientIp;
		this.cartao = cartao;
	}

	public Long getId() {
		return id;
	}

	public LocalDate getValidoAte() {
		return validoAte;
	}

	public String getDestino() {
		return destino;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public String getClientIp() {
		return clientIp;
	}

}
