package com.br.lucas.testetgid.api.model.input;

import java.util.List;

public record CompanyInputDTO(
        String name,
        String cnpj,
        Double balance,
        List<AddressInputDTO> addresses,
        List<PhonesInputDTO> phones
) {}
