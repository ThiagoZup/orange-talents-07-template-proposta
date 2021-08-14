package br.com.zupacademy.thiago.microserviceproposta.controller.dto;

import br.com.zupacademy.thiago.microserviceproposta.model.enums.ResultadoSolicitacao;

public class SolicitacaoAnaliseDto {

	private String documento;
	private String nome;
	private ResultadoSolicitacao resultadoSolicitacao;
	private String idProposta;
	
	public String getDocumento() {
		return documento;
	}
	public String getNome() {
		return nome;
	}
	public ResultadoSolicitacao getResultadoSolicitacao() {
		return resultadoSolicitacao;
	}
	public String getIdProposta() {
		return idProposta;
	}
}
