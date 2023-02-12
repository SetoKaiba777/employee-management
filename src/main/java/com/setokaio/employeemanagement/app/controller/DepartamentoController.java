package com.setokaio.employeemanagement.app.controller;

import com.setokaio.employeemanagement.app.dto.input.DepartamentoInputDTO;
import com.setokaio.employeemanagement.app.dto.input.FuncionarioInputDTO;
import com.setokaio.employeemanagement.app.dto.output.DepartamentoOutputDTO;
import com.setokaio.employeemanagement.app.dto.output.FuncionarioOutputDTO;
import com.setokaio.employeemanagement.core.mapper.DepartamentoMapper;
import com.setokaio.employeemanagement.core.mapper.FuncionarioMapper;
import com.setokaio.employeemanagement.domain.service.DepartamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

@Tag(name = "Departamentos Controller")
@RestController
@RequestMapping("/v1/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;


    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso!"),
            @ApiResponse(responseCode = "500", description = "Problema de conexão com o servidor.")
    })
    @GetMapping
    @Operation(summary = "Busca todos os Departamentos")
    public List<DepartamentoOutputDTO> todosDepartamento(){
        return DepartamentoMapper.toListDTO(departamentoService.listarTodos());
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso!"),
            @ApiResponse(responseCode = "404", description = "Departamento não encontrado."),
            @ApiResponse(responseCode = "500", description = "Problema de conexão com o servidor.")
    })
    @Operation(summary = "Busca Departamento por Id")
    @GetMapping("/{id}")
    public DepartamentoOutputDTO departamentoPorId(@PathVariable("id") Long id){
        return DepartamentoMapper.toDTO(departamentoService.pegarPorId(id));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso!"),
            @ApiResponse(responseCode = "404", description = "Departamento não encontrado."),
            @ApiResponse(responseCode = "500", description = "Problema de conexão com o servidor.")
    })
    @Operation(summary = "Busca Departamento e todos os funcionários Ativos")
    @GetMapping("/{id}/ativos")
    public DepartamentoOutputDTO departamentoPorIdComListaDeAtivos(@PathVariable("id") Long id){
        return DepartamentoMapper.toDTO(departamentoService.pegarPorIdComListaDeFuncionariosAtivos(id));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Departamento cadastrado com sucesso!"),
            @ApiResponse(responseCode = "404", description = "Departamento não encontrado."),
            @ApiResponse(responseCode = "500", description = "Problema de conexão com o servidor.")
    })
    @Operation(summary = "Adiciona um novo Departamento")
    @PostMapping
    public DepartamentoOutputDTO adicionaDepartamento(@RequestBody DepartamentoInputDTO departamentoInputDTO){
        return DepartamentoMapper.toDTO(departamentoService.salvarDepartamento(DepartamentoMapper.toEntity(departamentoInputDTO)));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Funcionário adicionado com sucesso!"),
            @ApiResponse(responseCode = "404", description = "Departamento não encontrado."),
            @ApiResponse(responseCode = "400", description = "CPF já cadastrado no sistema."),
            @ApiResponse(responseCode = "500", description = "Problema de conexão com o servidor.")
    })
    @Operation(summary = "Adiciona um Funcionário a um departamento")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{id}")
    public FuncionarioOutputDTO adicionaFuncionario(@Valid @RequestBody FuncionarioInputDTO funcionarioInputDTO, @PathVariable("id") Long id){

        return FuncionarioMapper.toDTO(departamentoService.adicionaFuncionario(id, FuncionarioMapper.toEntity(funcionarioInputDTO)));
    }
}
