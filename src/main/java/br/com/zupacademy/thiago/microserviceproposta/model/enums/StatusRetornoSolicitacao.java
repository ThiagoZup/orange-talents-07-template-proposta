package br.com.zupacademy.thiago.microserviceproposta.model.enums;

public enum StatusRetornoSolicitacao {
	COM_RESTRICAO, 
	SEM_RESTRICAO;
	
	public StatusProposta normaliza() {
		if(this.equals(SEM_RESTRICAO)) {
			return StatusProposta.ELEGIVEL;
		}else {
			return StatusProposta.NAO_ELEGIVEL;
		}
	}
}
