package br.com.zupacademy.thiago.microserviceproposta.func.nova_proposta;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.thiago.microserviceproposta.model.Endereco;

public class EnderecoForm {

	@NotBlank
	private String logradouro;
	
	@NotBlank
	private String numero;
	
	@NotBlank
	private String complemento;
	
	@NotBlank
	private String cidade;
	
	@NotBlank
	private String estado;
	
	@NotBlank
	private String cep;

	public String getLogradouro() {
		return logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}

	public String getCep() {
		return cep;
	}
	
	public Endereco toModel() {
		return new Endereco(logradouro, numero, complemento, cidade, estado, cep);
	}
	
}
