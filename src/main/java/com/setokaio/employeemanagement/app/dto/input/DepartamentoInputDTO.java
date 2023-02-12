package com.setokaio.employeemanagement.app.dto.input;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class DepartamentoInputDTO implements Serializable {
    private static final long serialVersionUID = 1L;



    @NotBlank
    @Schema(description = "Nome do departamento", example = "Financeiro")
    private String nome;

    @NotBlank
    @Schema(description = "Descrição das funcionalidades do departamento", example = "Responsável pelo fluxo de caixa")
    private String descricao;

    @NotNull
    @Schema(description = "Orçamento do departamento", example = "1000000")
    private BigDecimal budget;

}




