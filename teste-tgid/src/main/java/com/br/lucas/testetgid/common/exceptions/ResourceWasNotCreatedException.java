package com.br.lucas.testetgid.common.exceptions;

import java.io.Serial;

public class ResourceWasNotCreatedException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    public ResourceWasNotCreatedException(String message) {
        super(message);
    }
}
