package com.br.lucas.testetgid.api.validator.cnpj;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CNPJValidator implements ConstraintValidator<CNPJ, String> {

    @Override
    public void initialize(CNPJ constraintAnnotation) {
    }

    @Override
    public boolean isValid(String cnpj, ConstraintValidatorContext context) {
        if (cnpj == null) {
            return false;
        }

        String sanitizedCNPJ = sanitizeCNPJ(cnpj);

        if (!isValidLengthAndUniqueDigits(sanitizedCNPJ)) {
            return false;
        }

        return validateVerifierDigits(sanitizedCNPJ);
    }

    private String sanitizeCNPJ(String cnpj) {
        return cnpj.replaceAll("\\D", "");
    }

    private boolean isValidLengthAndUniqueDigits(String cnpj) {
        return cnpj.length() == 14 && !cnpj.matches("(\\d)\\1{13}");
    }

    private boolean validateVerifierDigits(String cnpj) {
        int firstVerifierDigit = calculateFirstVerifierDigit(cnpj);
        int secondVerifierDigit = calculateSecondVerifierDigit(cnpj, firstVerifierDigit);

        return firstVerifierDigit == Character.getNumericValue(cnpj.charAt(12)) &&
                secondVerifierDigit == Character.getNumericValue(cnpj.charAt(13));
    }

    private int calculateFirstVerifierDigit(String cnpj) {
        int[] weights = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int sum = 0;
        for (int i = 0; i < 12; i++) {
            sum += (Character.getNumericValue(cnpj.charAt(i))) * weights[i];
        }
        int remainder = sum % 11;
        return remainder < 2 ? 0 : 11 - remainder;
    }

    private int calculateSecondVerifierDigit(String cnpj, int firstVerifierDigit) {
        int[] weights = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int sum = 0;
        for (int i = 0; i < 12; i++) {
            sum += (Character.getNumericValue(cnpj.charAt(i))) * weights[i];
        }
        sum += firstVerifierDigit * weights[12];
        int remainder = sum % 11;
        return remainder < 2 ? 0 : 11 - remainder;
    }
}
