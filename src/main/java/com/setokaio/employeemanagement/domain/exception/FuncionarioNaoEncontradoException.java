package com.setokaio.employeemanagement.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class FuncionarioNaoEncontradoException extends RuntimeException{

    public FuncionarioNaoEncontradoException(String msg){
        super(msg);
    }
}
