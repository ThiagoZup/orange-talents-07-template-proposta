package br.com.zupacademy.thiago.microserviceproposta.controller.form;

import java.time.LocalDateTime;

import br.com.zupacademy.thiago.microserviceproposta.model.Bloqueio;
import br.com.zupacademy.thiago.microserviceproposta.model.Cartao;

public class BloqueioForm {

	private String id;
	private LocalDateTime bloqueadoEm;
	private String sistemaResponsavel;
	private boolean ativo;
	
	public String getId() {
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
	
	public Bloqueio toModel(Cartao cartao) {
		return new Bloqueio(id, bloqueadoEm, sistemaResponsavel, ativo, cartao);
	}
	
}
