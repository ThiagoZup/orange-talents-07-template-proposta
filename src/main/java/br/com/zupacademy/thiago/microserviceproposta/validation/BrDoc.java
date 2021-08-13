package br.com.zupacademy.thiago.microserviceproposta.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = {BrDocValidator.class})
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface BrDoc {

	String message() default "Documento deve ser um CPF ou CNPJ válido";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};

}
