package com.br.lucas.testetgid.api.validator;

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

        // Remove caracteres não numéricos
        String sanitizedCPF = cpf.replaceAll("\\D", "");

        if (!isValidLengthAndUniqueDigits(sanitizedCPF)) {
            return false;
        }

        // Calcula e verifica os dígitos verificadores
        return validateVerifierDigits(sanitizedCPF);
    }

    private boolean isValidLengthAndUniqueDigits(String cpf) {
        // Verifica se o CPF tem 11 dígitos e se todos os dígitos não são iguais
        return cpf.length() == 11 && !cpf.matches("(\\d)\\1{10}");
    }

    private boolean validateVerifierDigits(String cpf) {
        // Calcula os dígitos verificadores
        int firstVerifierDigit = calculateFirstVerifierDigit(cpf);
        int secondVerifierDigit = calculateSecondVerifierDigit(cpf, firstVerifierDigit);

        // Verificação final dos dígitos, comparando com os dígitos atuais do CPF
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
        sum += firstVerifierDigit * 2; // Multiplica o primeiro dígito verificador por 2
        int remainder = sum % 11;
        return remainder < 2 ? 0 : 11 - remainder;
    }
}