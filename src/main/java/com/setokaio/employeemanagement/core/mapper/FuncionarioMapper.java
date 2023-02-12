package com.setokaio.employeemanagement.core.mapper;

import com.setokaio.employeemanagement.app.dto.input.FuncionarioInputDTO;
import com.setokaio.employeemanagement.app.dto.output.FuncionarioOutputDTO;
import com.setokaio.employeemanagement.core.builder.FuncionarioBuilder;
import com.setokaio.employeemanagement.domain.entity.Funcionario;

import java.util.List;
import java.util.stream.Collectors;

public final class FuncionarioMapper {

    private FuncionarioMapper(){}

    public static Funcionario toEntity(FuncionarioInputDTO funcionarioInputDTO){
        return FuncionarioBuilder.builder()
                .cpf(funcionarioInputDTO.getCpf())
                .salario(funcionarioInputDTO.getSalario())
                .nome(funcionarioInputDTO.getNome())
                .build().toEntity();
    }

    public static List<FuncionarioOutputDTO> toListDTO(List<Funcionario> funcionarios){
        return funcionarios.stream()
                .map(FuncionarioMapper::toDTO)
                .collect(Collectors.toList());
    }

    public static FuncionarioOutputDTO toDTO(Funcionario funcionario){
        return FuncionarioOutputDTO.builder()
                .id(funcionario.getId())
                .cpf(funcionario.getCpf())
                .nome(funcionario.getNome())
                .departamentoId(funcionario.getDepartamento().getId())
                .salario(funcionario.getSalario())
                .status(funcionario.getStatus())
                .build();
    }
}
