package com.br.lucas.testetgid.api.model.input;

public record AddressInputDTO(
        String cep,
        String street,
        String number,
        String city
) {}
