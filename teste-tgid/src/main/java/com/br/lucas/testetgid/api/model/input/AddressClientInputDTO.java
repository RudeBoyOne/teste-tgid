package com.br.lucas.testetgid.api.model.input;

public record AddressClientInputDTO(
        String cep,
        String street,
        String number,
        String city
) {}
