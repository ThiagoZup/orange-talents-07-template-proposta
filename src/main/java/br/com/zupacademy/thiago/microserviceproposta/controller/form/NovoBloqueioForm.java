package br.com.zupacademy.thiago.microserviceproposta.controller.form;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.thiago.microserviceproposta.model.Bloqueio;
import br.com.zupacademy.thiago.microserviceproposta.model.Cartao;

public class NovoBloqueioForm {
	
	@NotBlank 
	private String sistemaResponsavel;
	@NotNull
	private boolean ativo;

	public String getSistemaResponsavel() {
		return sistemaResponsavel;
	}
	public boolean isAtivo() {
		return ativo;
	}
	
	public Bloqueio toModel(Cartao cartao) {
		return new Bloqueio(LocalDateTime.now(), sistemaResponsavel, ativo, cartao);
	}
	
}