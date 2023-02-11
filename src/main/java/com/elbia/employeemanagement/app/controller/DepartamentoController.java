package com.elbia.employeemanagement.app.controller;

import com.elbia.employeemanagement.app.dto.input.DepartamentoInputDTO;
import com.elbia.employeemanagement.app.dto.input.FuncionarioInputDTO;
import com.elbia.employeemanagement.app.dto.output.DepartamentoOutputDTO;
import com.elbia.employeemanagement.app.dto.output.FuncionarioOutputDTO;
import com.elbia.employeemanagement.core.mapper.DepartamentoMapper;
import com.elbia.employeemanagement.core.mapper.FuncionarioMapper;
import com.elbia.employeemanagement.domain.entity.Departamento;
import com.elbia.employeemanagement.domain.entity.Funcionario;
import com.elbia.employeemanagement.domain.service.DepartamentoService;
import com.elbia.employeemanagement.domain.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static com.elbia.employeemanagement.core.mapper.FuncionarioMapper.*;
import static com.elbia.employeemanagement.core.mapper.DepartamentoMapper.*;

@RestController
@RequestMapping("/v1/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping
    public List<DepartamentoOutputDTO> todosDepartamento(){
        return DepartamentoMapper.toListDTO(departamentoService.listarTodos());
    }

    @GetMapping("/{id}")
    public DepartamentoOutputDTO departamentoPorId(@PathVariable("id") Long id){
        return toDTO(departamentoService.pegarPorId(id));
    }

    @GetMapping("/{id}/ativos")
    public DepartamentoOutputDTO departamentoPorIdComListaDeAtivos(@PathVariable("id") Long id){
        return toDTO(departamentoService.pegarPorIdComListaDeFuncionariosAtivos(id));
    }

    @PostMapping
    public Departamento adicionaDepartamento(@RequestBody DepartamentoInputDTO departamentoInputDTO){
        return departamentoService.salvarDepartamento(toEntity(departamentoInputDTO));
    }
    @PostMapping("/{id}")
    public FuncionarioOutputDTO adicionaFuncionario(@Valid @RequestBody FuncionarioInputDTO funcionarioInputDTO, @PathVariable("id") Long id){

        return toDTO(departamentoService.adicionaFuncionario(id, toEntity(funcionarioInputDTO)));
    }
}
