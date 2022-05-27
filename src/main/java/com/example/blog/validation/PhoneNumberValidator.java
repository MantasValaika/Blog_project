package com.example.blog.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {

    private PhoneNumberType phoneNumberType;

    @Override
    public void initialize(PhoneNumber constraintAnnotation) {
        this.phoneNumberType = constraintAnnotation.phoneNumberType();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (phoneNumberType.equals(PhoneNumberType.FULL)) {
            return isFullNumberValid(value);
        }
        if (phoneNumberType.equals(PhoneNumberType.PARTIAL)) {
            return isPartialNumberValid(value);
        }
        return false;
    }

    private boolean isFullNumberValid(String value) {
        if (!value.startsWith("+")) {
            return false;
        }
        if (!value.startsWith("3706", 1)) {
            return false;
        }
        return value.length() == 12;
    }

    private boolean isPartialNumberValid(String value) {
        if (!value.startsWith("86")) {
            return false;
        }
        return value.length() == 9;
    }
}
