package com.br.lucas.testetgid.api.model.input;

import com.br.lucas.testetgid.api.validator.cpf.CPF;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record ClientInputDTO (
        String name,
        @NotBlank
        @CPF
        String cpf,
        List<AddressInputDTO> addresses,
        List<PhonesInputDTO> phones
) {}
