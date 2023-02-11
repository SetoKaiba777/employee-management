package com.elbia.employeemanagement.core.mapper;

import com.elbia.employeemanagement.app.dto.input.DepartamentoInputDTO;
import com.elbia.employeemanagement.app.dto.input.FuncionarioInputDTO;
import com.elbia.employeemanagement.app.dto.output.DepartamentoOutputDTO;
import com.elbia.employeemanagement.core.builder.DepartamentoBuilder;
import com.elbia.employeemanagement.core.builder.FuncionarioBuilder;
import com.elbia.employeemanagement.domain.entity.Departamento;
import com.elbia.employeemanagement.domain.entity.Funcionario;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.elbia.employeemanagement.core.mapper.FuncionarioMapper.*;

public final class DepartamentoMapper {

    private DepartamentoMapper(){}

    public static Departamento toEntity(DepartamentoInputDTO departamentoInputDTO){
        return DepartamentoBuilder.builder()
                .nome(departamentoInputDTO.getNome())
                .descricao(departamentoInputDTO.getDescricao())
                .budget(departamentoInputDTO.getBudget())
                .totalSalarios(BigDecimal.ZERO)
                .funcionarios(new ArrayList<Funcionario>())
                .build().toEntity();
    }

    public static List<DepartamentoOutputDTO> toListDTO(List<Departamento> departamentos){
        return departamentos.stream()
                .map(departamento -> toDTO(departamento))
                .collect(Collectors.toList());

    }
    public static DepartamentoOutputDTO toDTO(Departamento departamento){
        return DepartamentoOutputDTO.builder()
                .id(departamento.getId())
                .nome(departamento.getNome())
                .descricao(departamento.getDescricao())
                .budget(departamento.getBudget())
                .totalSalarios(departamento.getTotalSalarios())
                .funcionarios(FuncionarioMapper.toListDTO(departamento.getFuncionarios()))
                .build();
    }

}
