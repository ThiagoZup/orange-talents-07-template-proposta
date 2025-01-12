package br.com.zupacademy.thiago.microserviceproposta.func.associa_cartao;

import java.time.LocalDateTime;

import br.com.zupacademy.thiago.microserviceproposta.model.Cartao;
import br.com.zupacademy.thiago.microserviceproposta.model.Carteira;
import br.com.zupacademy.thiago.microserviceproposta.model.enums.EmissoresCarteira;

public class CarteiraForm {

	private String id;
	private String email;
	private LocalDateTime associadaEm;
	private EmissoresCarteira emissor;
	
	public String getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	public LocalDateTime getAssociadaEm() {
		return associadaEm;
	}
	public EmissoresCarteira getEmissor() {
		return emissor;
	}
	
	public Carteira toModel(Cartao cartao) {
		return new Carteira(id, email, associadaEm, emissor, cartao);
	}
}
