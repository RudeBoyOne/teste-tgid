package com.br.lucas.testetgid.common.exceptions.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.OffsetDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record Problem(
        Integer status,
        OffsetDateTime dateTime,
        String titulo,
        List<Field> fields
) {}
