package com.setokaio.employeemanagement.app.dto.output;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Data
public class DepartamentoOutputDTO {

    @Schema(description = "Id do departamento", example = "1")
    private long id;
    @Schema(description = "Nome do departamento", example = "Financeiro")
    private String nome;
    @Schema(description = "Descrição das funcionalidades do departamento", example = "Responsável pelo fluxo de caixa")
    private String descricao;

    @Schema(description = "Orçamento do departamento", example = "1000000")
    private BigDecimal budget;

    @Schema(description = "Total de Salários do Departamento", example = "10000")
    private BigDecimal totalSalarios;

    private List<FuncionarioOutputDTO> funcionarios;
}




