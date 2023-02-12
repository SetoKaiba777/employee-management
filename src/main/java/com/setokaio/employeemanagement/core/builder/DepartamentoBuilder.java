package com.setokaio.employeemanagement.core.builder;

import com.setokaio.employeemanagement.domain.entity.Departamento;
import com.setokaio.employeemanagement.domain.entity.Funcionario;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;

@Builder
public class DepartamentoBuilder {

    private long id;
    private String nome;
    private String descricao;
    private BigDecimal budget;
    private BigDecimal totalSalarios;
    private List<Funcionario> funcionarios;

    public Departamento toEntity(){
        return new Departamento(id,nome,descricao,budget,totalSalarios,funcionarios);
    }
}
