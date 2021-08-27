package br.com.zupacademy.thiago.microserviceproposta.func.nova_proposta;

import java.math.BigDecimal;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.security.crypto.encrypt.TextEncryptor;

import br.com.zupacademy.thiago.microserviceproposta.exception.UnprocessableEntityException;
import br.com.zupacademy.thiago.microserviceproposta.model.Endereco;
import br.com.zupacademy.thiago.microserviceproposta.model.Proposta;
import br.com.zupacademy.thiago.microserviceproposta.repository.PropostaRepository;
import br.com.zupacademy.thiago.microserviceproposta.validation.BrDoc;

public class NovaPropostaForm {

	@NotBlank
	@BrDoc(message = "Documento deve ser um CPF ou CNPJ válido")
	private String documento;
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	private String nome;
	
	@NotNull
	@Positive
	private BigDecimal salario;
	
	@Valid
	private EnderecoForm endereco;

	public String getDocumento() {
		return documento;
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}
	
	public BigDecimal getSalario() {
		return salario;
	}

	public EnderecoForm getEndereco() {
		return endereco;
	}


	
	public Proposta toModel(PropostaRepository repository, TextEncryptor encryptor) {
		String documentoHash = DigestUtils.sha256Hex(documento);
		System.out.println(documentoHash);
		Optional<Proposta> optional = repository.findByDocumentoHash(documentoHash);
		if(optional.isPresent()) {
			throw new UnprocessableEntityException("Não é permitida mais de uma proposta com o mesmo documento");
		}
		Endereco enderecoModel = this.endereco.toModel();
		return new Proposta(encryptor.encrypt(documento), documentoHash, email, nome, enderecoModel, salario);
	}
}
