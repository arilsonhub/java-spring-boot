package br.com.judice.servicos.domain.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.judice.servicos.domain.annotations.validator.CpfValidator;

@Constraint(validatedBy = {CpfValidator.class})
@Target({ElementType.FIELD})
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface Cpf {

	String message() default "O CPF informado é inválido";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}