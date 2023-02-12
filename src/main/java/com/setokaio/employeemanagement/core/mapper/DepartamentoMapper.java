package com.setokaio.employeemanagement.core.mapper;

import com.setokaio.employeemanagement.app.dto.input.DepartamentoInputDTO;
import com.setokaio.employeemanagement.app.dto.output.DepartamentoOutputDTO;
import com.setokaio.employeemanagement.core.builder.DepartamentoBuilder;
import com.setokaio.employeemanagement.domain.entity.Departamento;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class DepartamentoMapper {

    private DepartamentoMapper(){}

    public static Departamento toEntity(DepartamentoInputDTO departamentoInputDTO){
        return DepartamentoBuilder.builder()
                .nome(departamentoInputDTO.getNome())
                .descricao(departamentoInputDTO.getDescricao())
                .budget(departamentoInputDTO.getBudget())
                .totalSalarios(BigDecimal.ZERO)
                .funcionarios(new ArrayList<>())
                .build().toEntity();
    }

    public static List<DepartamentoOutputDTO> toListDTO(List<Departamento> departamentos){
        return departamentos.stream()
                .map(DepartamentoMapper::toDTO)
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
