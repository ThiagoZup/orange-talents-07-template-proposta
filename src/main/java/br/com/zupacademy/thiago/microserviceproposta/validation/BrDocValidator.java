package br.com.zupacademy.thiago.microserviceproposta.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.zupacademy.thiago.microserviceproposta.validation.utils.BR;

public class BrDocValidator implements ConstraintValidator<BrDoc, Object>{
	
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		if(BR.isValidCNPJ(String.valueOf(value))||BR.isValidCPF(String.valueOf(value))) {
			return true;
		}	
		return false;
	}
	
	

}
