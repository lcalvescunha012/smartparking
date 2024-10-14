package com.smartparking.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PlateValidator implements ConstraintValidator<ValidPlate, String> {

    // Regex para validar placas brasileiras no formato antigo e Mercosul
    private static final String PLATE_REGEX = "^[A-Z]{3}\\d{4}$|^[A-Z]{3}\\d[A-Z]\\d{2}$";

    @Override
    public void initialize(ValidPlate constraintAnnotation) {}

    @Override
    public boolean isValid(String plate, ConstraintValidatorContext context) {
        if (plate == null || plate.trim().isEmpty()) {
            return false;
        }
        return plate.matches(PLATE_REGEX);
    }
}
