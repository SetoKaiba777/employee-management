package com.elbia.employeemanagement.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FaltaOrcamentoException extends RuntimeException{
    private final long serialVersionUID = 1L;

    public FaltaOrcamentoException(String msg){
        super(msg);
    }
}
