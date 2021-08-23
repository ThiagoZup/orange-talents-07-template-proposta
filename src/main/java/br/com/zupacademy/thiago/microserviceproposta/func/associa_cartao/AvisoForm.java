package br.com.zupacademy.thiago.microserviceproposta.func.associa_cartao;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.zupacademy.thiago.microserviceproposta.model.Aviso;
import br.com.zupacademy.thiago.microserviceproposta.model.Cartao;

public class AvisoForm {

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate validoAte;
	private String destino;
	
	public LocalDate getValidoAte() {
		return validoAte;
	}
	public String getDestino() {
		return destino;
	}
	
	public Aviso toModel(Cartao cartao) {
		return new Aviso(validoAte, destino, cartao);
	}
}
