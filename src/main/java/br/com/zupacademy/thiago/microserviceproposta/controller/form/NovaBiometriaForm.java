package br.com.zupacademy.thiago.microserviceproposta.controller.form;

import javax.validation.constraints.Pattern;

import br.com.zupacademy.thiago.microserviceproposta.model.Biometria;

public class NovaBiometriaForm {

	private String base64;

	@Pattern(regexp = "^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)?$")
	public String getBase64() {
		return base64;
	}
	
	public Biometria toModel() {
		return new Biometria(this.base64);
	}
}
