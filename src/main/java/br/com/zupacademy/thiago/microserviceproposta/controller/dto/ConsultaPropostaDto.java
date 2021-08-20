package br.com.zupacademy.thiago.microserviceproposta.controller.dto;

import java.math.BigDecimal;

import br.com.zupacademy.thiago.microserviceproposta.model.Proposta;
import br.com.zupacademy.thiago.microserviceproposta.model.enums.StatusProposta;

public class ConsultaPropostaDto {
	
	private String documento;
	private String email;
	private String nome;
	private BigDecimal salario;
	private StatusProposta statusCartao;
	private ConsultaPropostaEnderecoDto endereco;
	private ConsultaPropostaCartaoDto cartao;
	
	public ConsultaPropostaDto(Proposta proposta) {
		this.documento = proposta.getDocumento();
		this.email = proposta.getEmail();
		this.nome = proposta.getNome();
		this.salario = proposta.getSalario();
		this.statusCartao = proposta.getStatusCartao();
		this.endereco = new ConsultaPropostaEnderecoDto(proposta.getEndereco());
		ConsultaPropostaCartaoDto cartao = null;
		if(proposta.getCartao() != null) cartao = new ConsultaPropostaCartaoDto(proposta.getCartao());
		this.cartao = cartao;
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

	public StatusProposta getStatusCartao() {
		return statusCartao;
	}

	public ConsultaPropostaEnderecoDto getEndereco() {
		return endereco;
	}

	public ConsultaPropostaCartaoDto getCartao() {
		return cartao;
	}
}
