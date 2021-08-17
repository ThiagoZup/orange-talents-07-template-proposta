package br.com.zupacademy.thiago.microserviceproposta.model.enums;

public enum StatusRetornoSolicitacao {
	COM_RESTRICAO, 
	SEM_RESTRICAO;
	
	public StatusCartao normaliza() {
		if(this.equals(SEM_RESTRICAO)) {
			return StatusCartao.ELEGIVEL;
		}else {
			return StatusCartao.NAO_ELEGIVEL;
		}
	}
}
