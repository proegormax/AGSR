package com.monitorsensors.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = RangeValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidRange {
    String message() default "Значение 'from' должно быть меньше 'to'";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
