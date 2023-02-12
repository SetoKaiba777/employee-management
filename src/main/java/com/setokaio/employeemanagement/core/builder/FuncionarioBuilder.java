package com.setokaio.employeemanagement.core.builder;

import com.setokaio.employeemanagement.domain.constants.EmployeeStatus;
import com.setokaio.employeemanagement.domain.entity.Departamento;
import com.setokaio.employeemanagement.domain.entity.Funcionario;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
public class FuncionarioBuilder {

    private long id;
    private String nome;
    private String cpf;
    private EmployeeStatus status;
    private BigDecimal salario;
    private LocalDate rejectionDate;
    private Departamento departamento;

    public Funcionario toEntity(){
        return new Funcionario(id,nome,cpf,status,salario,rejectionDate,departamento);
    }
}
