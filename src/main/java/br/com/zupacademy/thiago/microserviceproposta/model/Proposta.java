package br.com.zupacademy.thiago.microserviceproposta.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.zupacademy.thiago.microserviceproposta.model.enums.StatusCartao;

@Entity
public class Proposta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String documento;
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	private String nome;
	
	@NotNull
	@Positive
	private BigDecimal salario;
	
	@Enumerated(EnumType.STRING)
	private StatusCartao statusCartao;
	
	@Embedded
	private Endereco endereco;
	
	@Deprecated
	public Proposta() {
	}

	public Proposta(@NotBlank String documento, @NotBlank @Email String email, @NotBlank String nome, Endereco endereco,
			@NotNull @Positive BigDecimal salario) {
		super();
		this.documento = documento;
		this.email = email;
		this.nome = nome;
		this.endereco = endereco;
		this.salario = salario;
	}

	public Long getId() {
		return id;
	}

	public String getDocumento() {
		return documento;
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}
	
	public BigDecimal getSalario() {
		return salario;
	}

	public StatusCartao getStatusCartao() {
		return statusCartao;
	}

	public void setStatusCartao(StatusCartao statusCartao) {
		this.statusCartao = statusCartao;
	}

	public Endereco getEndereco() {
		return endereco;
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
		Proposta other = (Proposta) obj;
		return Objects.equals(id, other.id);
	}
}
