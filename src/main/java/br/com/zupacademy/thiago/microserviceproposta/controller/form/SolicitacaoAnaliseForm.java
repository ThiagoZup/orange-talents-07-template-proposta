package br.com.zupacademy.thiago.microserviceproposta.controller.form;

import br.com.zupacademy.thiago.microserviceproposta.model.enums.StatusRetornoSolicitacao;

public class SolicitacaoAnaliseForm {

	private String documento;
	private String nome;
	private StatusRetornoSolicitacao resultadoSolicitacao;
	private String idProposta;
	
	public String getDocumento() {
		return documento;
	}
	public String getNome() {
		return nome;
	}
	public StatusRetornoSolicitacao getResultadoSolicitacao() {
		return resultadoSolicitacao;
	}
	public String getIdProposta() {
		return idProposta;
	}
}
