package com.setokaio.employeemanagement.domain.service;

import com.setokaio.employeemanagement.domain.entity.Funcionario;

import java.math.BigDecimal;


public interface FuncionarioService {

    Funcionario aumentaSalario(Long id, BigDecimal valor);

}
