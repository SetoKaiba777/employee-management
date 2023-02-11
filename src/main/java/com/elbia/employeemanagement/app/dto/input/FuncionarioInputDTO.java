package com.elbia.employeemanagement.app.dto.input;

import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class FuncionarioInputDTO {

    @NotBlank
    private String nome;
    @NotBlank
    @CPF
    private String cpf;
    @NotNull
    private BigDecimal salario;
}

