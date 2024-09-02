package com.br.lucas.testetgid.api.model.input;

import java.util.List;

public record ClientInputDTO (
        String name,
        String cpf,
        List<AddressClientInputDTO> addresses,
        List<PhonesClientInputDTO> phones
) {}
