package com.elbia.employeemanagement.core.builder;

import com.elbia.employeemanagement.domain.constants.EmployeeStatus;
import com.elbia.employeemanagement.domain.entity.Departamento;
import com.elbia.employeemanagement.domain.entity.Funcionario;
import lombok.Builder;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.time.LocalDate;
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
