package br.com.zupacademy.thiago.microserviceproposta.func.aviso_cartao;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.zupacademy.thiago.microserviceproposta.model.Aviso;
import br.com.zupacademy.thiago.microserviceproposta.model.Cartao;

public class NovoAvisoForm {

	@NotBlank
	private String destino;
	
	@NotNull
	@Future
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate validoAte;

	public String getDestino() {
		return destino;
	}

	
	public LocalDate getValidoAte() {
		return validoAte;
	}


	public Aviso toModel(Cartao cartao, String userAgent, String clientIp) {
		return new Aviso(validoAte, destino, userAgent, clientIp, cartao);
	}
	
}
