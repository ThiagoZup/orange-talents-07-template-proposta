package br.com.zupacademy.thiago.microserviceproposta.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Biometria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String base64;
	
	@Deprecated
	public Biometria(){
	}

	public Biometria(String base64) {
		this.base64 = base64;
	}

	public Long getId() {
		return id;
	}

	public String getBase64() {
		return base64;
	}
}
