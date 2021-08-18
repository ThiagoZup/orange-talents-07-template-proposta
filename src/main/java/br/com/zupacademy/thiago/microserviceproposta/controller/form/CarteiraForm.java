package br.com.zupacademy.thiago.microserviceproposta.controller.form;

import java.time.LocalDateTime;

import br.com.zupacademy.thiago.microserviceproposta.model.Cartao;
import br.com.zupacademy.thiago.microserviceproposta.model.Carteira;

public class CarteiraForm {

	private String id;
	private String email;
	private LocalDateTime associadaEm;
	private String emissor;
	
	public String getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	public LocalDateTime getAssociadaEm() {
		return associadaEm;
	}
	public String getEmissor() {
		return emissor;
	}
	
	public Carteira toModel(Cartao cartao) {
		return new Carteira(id, email, associadaEm, emissor, cartao);
	}
}
