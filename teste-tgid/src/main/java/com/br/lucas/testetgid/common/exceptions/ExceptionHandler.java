package com.br.lucas.testetgid.common.exceptions;

import com.br.lucas.testetgid.common.exceptions.model.Field;
import com.br.lucas.testetgid.common.exceptions.model.Problem;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    private final MessageSource messageSource;


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders
            headers, HttpStatusCode status, WebRequest request) {

        List<Field> fields = new ArrayList<>();

        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            String name = ((FieldError) error).getField();
            String message = messageSource.getMessage(error, LocaleContextHolder.getLocale());
            fields.add(new Field(name, message));
        }

        Problem problem = new Problem(
                status.value(),
                OffsetDateTime.now(),
                "Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente!",
                fields
        );

        return handleExceptionInternal(ex, problem , headers, status, request);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ResourceWasNotCreatedException.class)
    public ResponseEntity<Object> handleResourceWasNotCreatedException(ResourceWasNotCreatedException ex, WebRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;

        Problem problem = new Problem(
                status.value(),
                OffsetDateTime.now(),
                ex.getMessage(),
                null
        );
        return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;

        Problem problem = new Problem(
                status.value(),
                OffsetDateTime.now(),
                ex.getMessage(),
                null
        );
        return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
    }
}
