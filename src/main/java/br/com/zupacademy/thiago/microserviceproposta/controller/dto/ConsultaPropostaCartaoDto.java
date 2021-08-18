package br.com.zupacademy.thiago.microserviceproposta.controller.dto;

import java.time.LocalDateTime;

import br.com.zupacademy.thiago.microserviceproposta.model.Cartao;

public class ConsultaPropostaCartaoDto {

	private String id;
	private LocalDateTime emitidoEm;
	public ConsultaPropostaCartaoDto(Cartao cartao) {
		this.id = cartao.getId();
		this.emitidoEm = cartao.getEmitidoEm();
	}
	public String getId() {
		return id;
	}
	public LocalDateTime getEmitidoEm() {
		return emitidoEm;
	}	
}
