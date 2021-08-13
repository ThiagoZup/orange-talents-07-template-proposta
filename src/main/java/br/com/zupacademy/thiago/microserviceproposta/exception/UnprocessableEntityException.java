package br.com.zupacademy.thiago.microserviceproposta.exception;

public class UnprocessableEntityException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public UnprocessableEntityException(String msg) {
		super(msg);
	}
	
	public UnprocessableEntityException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
