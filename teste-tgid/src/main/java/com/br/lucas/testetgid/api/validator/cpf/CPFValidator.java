package com.br.lucas.testetgid.api.validator.cpf;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CPFValidator implements ConstraintValidator<CPF, String> {

    @Override
    public void initialize(CPF constraintAnnotation) {
    }

    @Override
    public boolean isValid(String cpf, ConstraintValidatorContext context) {
        if (cpf == null) {
            return false;
        }

        String sanitizedCPF = cpf.replaceAll("\\D", "");

        if (!isValidLengthAndUniqueDigits(sanitizedCPF)) {
            return false;
        }

        return validateVerifierDigits(sanitizedCPF);
    }

    private boolean isValidLengthAndUniqueDigits(String cpf) {
        return cpf.length() == 11 && !cpf.matches("(\\d)\\1{10}");
    }

    private boolean validateVerifierDigits(String cpf) {
        int firstVerifierDigit = calculateFirstVerifierDigit(cpf);
        int secondVerifierDigit = calculateSecondVerifierDigit(cpf, firstVerifierDigit);

        return firstVerifierDigit == Character.getNumericValue(cpf.charAt(9)) &&
                secondVerifierDigit == Character.getNumericValue(cpf.charAt(10));
    }

    private int calculateFirstVerifierDigit(String cpf) {
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += (Character.getNumericValue(cpf.charAt(i))) * (10 - i);
        }
        int remainder = sum % 11;
        return remainder < 2 ? 0 : 11 - remainder;
    }

    private int calculateSecondVerifierDigit(String cpf, int firstVerifierDigit) {
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += (Character.getNumericValue(cpf.charAt(i))) * (11 - i);
        }
        sum += firstVerifierDigit * 2;
        int remainder = sum % 11;
        return remainder < 2 ? 0 : 11 - remainder;
    }
}