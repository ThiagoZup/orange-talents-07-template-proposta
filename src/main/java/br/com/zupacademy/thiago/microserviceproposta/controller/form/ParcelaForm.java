package br.com.zupacademy.thiago.microserviceproposta.controller.form;

import java.math.BigDecimal;

import br.com.zupacademy.thiago.microserviceproposta.model.Cartao;
import br.com.zupacademy.thiago.microserviceproposta.model.Parcela;

public class ParcelaForm {
	
	private String id;
	private Integer quantidade;
	private BigDecimal valor;
	
	public String getId() {
		return id;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public BigDecimal getValor() {
		return valor;
	}
	
	public Parcela toModel(Cartao cartao) {
		return new Parcela(id, quantidade, valor, cartao);
	}
}
