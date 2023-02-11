package com.elbia.employeemanagement.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class DepartamentoNaoEncontradoException extends RuntimeException{
    private final long serialVersionUID = 1L;

    public DepartamentoNaoEncontradoException(String msg){
        super(msg);
    }
}
