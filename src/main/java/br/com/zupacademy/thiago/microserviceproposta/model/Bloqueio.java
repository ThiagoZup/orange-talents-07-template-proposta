package br.com.zupacademy.thiago.microserviceproposta.model;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Bloqueio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime bloqueadoEm;
	private String sistemaResponsavel;
	private boolean ativo;
	
	@ManyToOne
	private Cartao cartao;
	
	@Deprecated
	public Bloqueio() {
	}

	public Bloqueio(LocalDateTime bloqueadoEm, String sistemaResponsavel, boolean ativo, Cartao cartao) {
		this.bloqueadoEm = bloqueadoEm;
		this.sistemaResponsavel = sistemaResponsavel;
		this.ativo = ativo;
		this.cartao = cartao;
	}

	public Long getId() {
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bloqueio other = (Bloqueio) obj;
		return Objects.equals(id, other.id);
	}
	
}
