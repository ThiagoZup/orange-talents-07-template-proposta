package br.com.zupacademy.thiago.microserviceproposta.func.carteira_cartao;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.thiago.microserviceproposta.model.Cartao;
import br.com.zupacademy.thiago.microserviceproposta.model.Carteira;
import br.com.zupacademy.thiago.microserviceproposta.model.enums.EmissoresCarteira;

public class NovaCarteiraForm {

	@Email
	@NotBlank
	private String email;
	
	@NotNull
	private EmissoresCarteira emissor;

	public String getEmail() {
		return email;
	}

	public EmissoresCarteira getEmissor() {
		return emissor;
	}
	
	public Carteira toModel(Cartao cartao) {
		return new Carteira(email, emissor, cartao);
	}
	
	
}
