package br.com.zupacademy.thiago.microserviceproposta.func.consulta_proposta;

import br.com.zupacademy.thiago.microserviceproposta.model.Endereco;

public class ConsultaPropostaEnderecoDto {
	
	private String logradouro;
	private String numero;
	private String complemento;
	private String cidade;
	private String estado;
	private String cep;
	public ConsultaPropostaEnderecoDto(Endereco endereco) {
		this.logradouro = endereco.getLogradouro();
		this.numero = endereco.getNumero();
		this.complemento = endereco.getComplemento();
		this.cidade = endereco.getCidade();
		this.estado = endereco.getEstado();
		this.cep = endereco.getCep();
	}
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
}
