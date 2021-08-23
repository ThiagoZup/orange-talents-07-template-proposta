package br.com.zupacademy.thiago.microserviceproposta.func.biometria_cartao;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import br.com.zupacademy.thiago.microserviceproposta.model.Biometria;

public class NovaBiometriaForm {
	
	@Pattern(regexp = "^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)?$")
	@NotBlank
	private String base64;


	public String getBase64() {
		return base64;
	}
	
	public Biometria toModel() {
		return new Biometria(this.base64);
	}
}
