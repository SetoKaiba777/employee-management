package com.setokaio.employeemanagement.app.dto.output;

import com.setokaio.employeemanagement.domain.constants.EmployeeStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;


@Builder
@Data
public class FuncionarioOutputDTO {

    @Schema(description = "Id do Funcionário", example = "1")
    private long id;
    @Schema(description = "Nome do Funcionário", example = "João José")
    private String nome;
    @Schema(description = "CPF do Funcionário", example = "405.172.600-26")
    private String cpf;

    @Schema(description = "Salário do Funcionário", example = "1500")
    private BigDecimal salario;

    @Schema(description = "Id do departamento onde foi registrado", example = "1")
    private long departamentoId;

    @Schema(description = "Status da contratação", example = "ATIVO")
    private EmployeeStatus status;

}

