package br.com.zupacademy.thiago.microserviceproposta.model;

import java.time.LocalDateTime;

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
	private LocalDateTime validoAte;
	private String destino;
	
	@ManyToOne
	private Cartao cartao;
	
	@Deprecated
	public Aviso() {
	}

	public Aviso(LocalDateTime validoAte, String destino, Cartao cartao) {
		this.validoAte = validoAte;
		this.destino = destino;
		this.cartao = cartao;
	}

	public Long getId() {
		return id;
	}

	public LocalDateTime getValidoAte() {
		return validoAte;
	}

	public String getDestino() {
		return destino;
	}

	public Cartao getCartao() {
		return cartao;
	}
}
