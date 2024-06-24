package com.bankmanagement.client.bao;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = ValidateDate.class)
@Retention(RUNTIME)
@Target({ TYPE, FIELD, METHOD })
public @interface CheckDate {
	 String message() default "Age Must Be min 18Years";

	    Class<?>[] groups() default {};

	    Class<? extends Payload>[] payload() default {};
}
