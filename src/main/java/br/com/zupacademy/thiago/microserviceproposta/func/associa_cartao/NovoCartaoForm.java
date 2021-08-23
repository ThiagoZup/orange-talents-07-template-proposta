package br.com.zupacademy.thiago.microserviceproposta.func.associa_cartao;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class NovoCartaoForm {

	private String id;
	private LocalDateTime emitidoEm;
	private String titular;
	private List<BloqueioForm> bloqueios;
	private List<AvisoForm> avisos;
	private List<CarteiraForm> carteiras;
	private List<ParcelaForm> parcelas;
	private BigDecimal limite;
	private RenegociacaoForm renegociacao;
	private VencimentoForm vencimento;
	private Long idProposta;

	public String getId() {
		return id;
	}

	public LocalDateTime getEmitidoEm() {
		return emitidoEm;
	}

	public String getTitular() {
		return titular;
	}

	public List<BloqueioForm> getBloqueios() {
		return bloqueios;
	}

	public List<AvisoForm> getAvisos() {
		return avisos;
	}

	public List<CarteiraForm> getCarteiras() {
		return carteiras;
	}

	public List<ParcelaForm> getParcelas() {
		return parcelas;
	}

	public BigDecimal getLimite() {
		return limite;
	}

	public RenegociacaoForm getRenegociacao() {
		return renegociacao;
	}

	public VencimentoForm getVencimento() {
		return vencimento;
	}

	public Long getIdProposta() {
		return idProposta;
	}
	
	@Override
	public String toString() {
		String string = this.getId()
				+ this.getTitular()
				+ this.getAvisos()
				+ this.getBloqueios()
				+ this.getCarteiras()
				+ this.getEmitidoEm()
				+ this.getLimite()
				+ this.getParcelas()
				+ this.getRenegociacao()
				+ this.getVencimento();
		return string;
	}
}
