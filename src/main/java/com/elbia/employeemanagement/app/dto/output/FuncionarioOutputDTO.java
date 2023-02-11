package com.elbia.employeemanagement.app.dto.output;

import com.elbia.employeemanagement.domain.constants.EmployeeStatus;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class FuncionarioOutputDTO {

    private long id;
    private String nome;
    private String cpf;
    private BigDecimal salario;
    private long departamentoId;
    private EmployeeStatus status;

}

