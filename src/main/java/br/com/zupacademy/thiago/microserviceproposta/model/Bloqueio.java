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
	private LocalDateTime bloqueadoEm = LocalDateTime.now();
	private String userAgent;
	private String clientIp;
	
	private boolean ativo = true;
	
	@ManyToOne
	private Cartao cartao;
	
	@Deprecated
	public Bloqueio() {
	}

	public Bloqueio(LocalDateTime bloqueadoEm, String clientIp, boolean ativo, Cartao cartao) {
		this.bloqueadoEm = bloqueadoEm;
		this.clientIp = clientIp;
		this.ativo = ativo;
		this.cartao = cartao;
	}

	public Bloqueio(String userAgent, String clientIp, Cartao cartao) {
		super();
		this.userAgent = userAgent;
		this.clientIp = clientIp;
		this.cartao = cartao;
	}

	public Long getId() {
		return id;
	}

	public LocalDateTime getBloqueadoEm() {
		return bloqueadoEm;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public String getClientIp() {
		return clientIp;
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
