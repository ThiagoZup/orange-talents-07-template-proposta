package br.com.zupacademy.thiago.microserviceproposta.func.viagem_cartao;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.zupacademy.thiago.microserviceproposta.model.Cartao;
import br.com.zupacademy.thiago.microserviceproposta.model.Viagem;

public class NovaViagemForm {

	@NotBlank
	private String destino;
	
	@NotNull
	@Future
	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDate dataTermino;

	public String getDestino() {
		return destino;
	}

	public LocalDate getDataTermino() {
		return dataTermino;
	}
	
	public Viagem toModel(Cartao cartao, String userAgent, String clientIp) {
		return new Viagem(destino, dataTermino, userAgent, clientIp, cartao);
	}
	
}
