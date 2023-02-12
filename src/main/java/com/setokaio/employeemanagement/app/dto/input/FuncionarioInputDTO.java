package com.setokaio.employeemanagement.app.dto.input;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class FuncionarioInputDTO {

    @NotBlank
    @Schema(description = "Nome do Funcionário", example = "João José")
    private String nome;

    @CPF
    @NotBlank
    @Schema(description = "CPF do Funcionário", example = "405.172.600-26")
    private String cpf;

    @NotNull
    @Schema(description = "Salário do Funcionário", example = "1500")
    private BigDecimal salario;

}

