package br.com.zupacademy.thiago.microserviceproposta.controller.form;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.zupacademy.thiago.microserviceproposta.model.Endereco;
import br.com.zupacademy.thiago.microserviceproposta.model.Proposta;
import br.com.zupacademy.thiago.microserviceproposta.validation.BrDoc;

public class NovaPropostaForm {

	@NotBlank
	@BrDoc(message = "Documento deve ser um CPF ou CNPJ válido")
	private String documento;
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	private String nome;
	
	@NotNull
	@Positive
	private BigDecimal salario;
	
	@Valid
	private NovoEnderecoForm endereco;

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

	public NovoEnderecoForm getEndereco() {
		return endereco;
	}


	
	public Proposta toModel() {
		Endereco enderecoModel = this.endereco.toModel();
		return new Proposta(documento, email, nome, enderecoModel, salario);
	}
}
