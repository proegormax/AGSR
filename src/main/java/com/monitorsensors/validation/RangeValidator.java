package com.monitorsensors.validation;

import com.monitorsensors.model.Range;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RangeValidator implements ConstraintValidator<ValidRange, Range> {

    @Override
    public boolean isValid(Range range, ConstraintValidatorContext context) {
        if (range == null) return true; // @NotNull обрабатывается отдельно
        if (range.getFromValue() == null || range.getToValue() == null) return true;
        return range.getFromValue() < range.getToValue();
    }
}
