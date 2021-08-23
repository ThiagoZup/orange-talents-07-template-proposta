package br.com.zupacademy.thiago.microserviceproposta.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Viagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String destino;
	
	@NotNull
	@Future
	private LocalDate dataTermino;
	
	@NotBlank
	private String userAgent;
	
	@NotBlank
	private String clientIp;
	
	private LocalDateTime instanteCriacao = LocalDateTime.now();
	
	@NotNull
	@ManyToOne
	private Cartao cartao;
	
	@Deprecated
	public Viagem(){
	}

	public Viagem(@NotBlank String destino, @NotNull @Future LocalDate dataTermino, @NotBlank String userAgent,
			@NotBlank String clientIp, @NotNull Cartao cartao) {
		super();
		this.destino = destino;
		this.dataTermino = dataTermino;
		this.userAgent = userAgent;
		this.clientIp = clientIp;
		this.cartao = cartao;
	}

	public Long getId() {
		return id;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public String getDestino() {
		return destino;
	}

	public LocalDate getDataTermino() {
		return dataTermino;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public String getClientIp() {
		return clientIp;
	}

	public LocalDateTime getInstanteCriacao() {
		return instanteCriacao;
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
		Viagem other = (Viagem) obj;
		return Objects.equals(id, other.id);
	}
}