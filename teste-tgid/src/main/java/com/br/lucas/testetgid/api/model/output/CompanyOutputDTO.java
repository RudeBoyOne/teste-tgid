package com.br.lucas.testetgid.api.model.output;

public record CompanyOutputDTO(
        String name,
        String cnpj,
        Double balance
) {}
