package br.com.zupacademy.thiago.microserviceproposta.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.com.zupacademy.thiago.microserviceproposta.controller.form.NovoCartaoForm;
import br.com.zupacademy.thiago.microserviceproposta.exception.ObjectNotFoundException;
import br.com.zupacademy.thiago.microserviceproposta.repository.PropostaRepository;

@Entity
public class Cartao {

	@Id
	private String id;
	private LocalDateTime emitidoEm;
	private String titular;
	
	@OneToMany(mappedBy = "cartao", cascade = CascadeType.MERGE)
	private List<Bloqueio> bloqueios = new ArrayList<>();
	
	@OneToMany(mappedBy = "cartao", cascade = CascadeType.PERSIST)
	private List<Aviso> avisos = new ArrayList<>();
	
	@OneToMany(mappedBy = "cartao", cascade = CascadeType.PERSIST)
	private List<Carteira> carteiras = new ArrayList<>();
	
	@OneToMany(mappedBy = "cartao", cascade = CascadeType.PERSIST)
	private List<Parcela> parcelas = new ArrayList<>();
	
	private BigDecimal limite;
	
	@OneToOne(mappedBy = "cartao", cascade = CascadeType.PERSIST)
	private Renegociacao renegociacao;
	
	@OneToOne(mappedBy = "cartao", cascade = CascadeType.PERSIST)
	private Vencimento vencimento;
	
	@OneToOne
	private Proposta proposta;
	
	@OneToOne(cascade = CascadeType.MERGE)
	private Biometria biometria;
	
	@Deprecated
	public Cartao() {
	}
	
	public Cartao(NovoCartaoForm form, PropostaRepository propostaRepository) {
		
		Optional<Proposta> proposta = propostaRepository.findById(form.getIdProposta());
		if (proposta.isEmpty()) {
			throw new ObjectNotFoundException("Proposta não encontrada");
		}

		List<Bloqueio> bloqueios = form.getBloqueios().stream().map(bloqueio -> bloqueio.toModel(this))
				.collect(Collectors.toList());
		List<Aviso> avisos = form.getAvisos().stream().map(aviso -> aviso.toModel(this)).collect(Collectors.toList());
		List<Carteira> carteiras = form.getCarteiras().stream().map(carteira -> carteira.toModel(this))
				.collect(Collectors.toList());
		List<Parcela> parcelas = form.getParcelas().stream().map(parcela -> parcela.toModel(this)).collect(Collectors.toList());

		Renegociacao renegociacao = null;
		if (form.getRenegociacao() != null) {
			renegociacao = form.getRenegociacao().toModel(this);
		}
		
		Vencimento vencimento = null;
		if (form.getVencimento() != null) {
			vencimento = form.getVencimento().toModel(this);
		}
		
		this.id = form.getId();
		this.emitidoEm = form.getEmitidoEm();
		this.titular = form.getTitular();
		this.bloqueios = bloqueios;
		this.avisos = avisos;
		this.carteiras = carteiras;
		this.parcelas = parcelas;
		this.limite = form.getLimite();
		this.renegociacao = renegociacao;
		this.vencimento = vencimento;
		this.proposta = proposta.get();
	}

	public String getId() {
		return id;
	}

	public LocalDateTime getEmitidoEm() {
		return emitidoEm;
	}

	public String getTitular() {
		return titular;
	}

	public List<Bloqueio> getBloqueios() {
		return bloqueios;
	}

	public List<Aviso> getAvisos() {
		return avisos;
	}

	public List<Carteira> getCarteiras() {
		return carteiras;
	}

	public List<Parcela> getParcelas() {
		return parcelas;
	}

	public BigDecimal getLimite() {
		return limite;
	}

	public Renegociacao getRenegociacao() {
		return renegociacao;
	}

	public Vencimento getVencimento() {
		return vencimento;
	}

	public Proposta getProposta() {
		return proposta;
	}

	public Biometria getBiometria() {
		return biometria;
	}

	public void setBiometria(Biometria biometria) {
		this.biometria = biometria;
	}	
	
	public void addBloqueio(Bloqueio bloqueio) {
		this.bloqueios.add(bloqueio);
	}
}
