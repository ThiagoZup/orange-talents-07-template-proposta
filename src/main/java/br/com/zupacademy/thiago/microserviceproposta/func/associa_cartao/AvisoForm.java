package br.com.zupacademy.thiago.microserviceproposta.func.associa_cartao;

import java.time.LocalDateTime;

import br.com.zupacademy.thiago.microserviceproposta.model.Aviso;
import br.com.zupacademy.thiago.microserviceproposta.model.Cartao;

public class AvisoForm {

	private LocalDateTime validoAte;
	private String destino;
	
	public LocalDateTime getValidoAte() {
		return validoAte;
	}
	public String getDestino() {
		return destino;
	}
	
	public Aviso toModel(Cartao cartao) {
		return new Aviso(validoAte, destino, cartao);
	}
}
