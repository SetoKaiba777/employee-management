package com.setokaio.employeemanagement.domain.service;

import com.setokaio.employeemanagement.domain.entity.Departamento;
import com.setokaio.employeemanagement.domain.entity.Funcionario;

import java.util.List;


public interface DepartamentoService {
    Departamento pegarPorId(Long id);

    Departamento pegarPorIdComListaDeFuncionariosAtivos(Long id);

    List<Departamento> listarTodos();

    Departamento salvarDepartamento(Departamento departamento);

    Funcionario adicionaFuncionario(Long idDepartamento, Funcionario funcionario);

}