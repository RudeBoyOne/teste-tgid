package com.br.lucas.testetgid.domain.entity.enums;

public enum TypeTax {

    withdrawal(0),
    deposit(1);

    private final int code;

    private TypeTax(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static TypeTax valueOfTypeTax(int code) {
        for (TypeTax value : TypeTax.values()) {
            if (code == value.getCode()) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid TypeTax code: " + code);
    }
}
