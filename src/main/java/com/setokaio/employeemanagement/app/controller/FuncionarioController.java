package com.setokaio.employeemanagement.app.controller;

import com.setokaio.employeemanagement.app.dto.output.FuncionarioOutputDTO;
import com.setokaio.employeemanagement.core.mapper.FuncionarioMapper;
import com.setokaio.employeemanagement.domain.service.FuncionarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Tag(name = "Funcionários Controller")
@RestController
@RequestMapping("/v1/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Salário aumentado com sucesso!"),
            @ApiResponse(responseCode = "404", description = "Funcionário não encontrado."),
            @ApiResponse(responseCode = "400", description = "Orçamento insuficiente."),
            @ApiResponse(responseCode = "500", description = "Problema de conexão com o servidor.")
    })
    @Operation(summary = "Aumenta o salário de um funcionário")
    @PutMapping("/{id}")
    public FuncionarioOutputDTO aumentaSalario(@PathVariable("id") Long id, @RequestBody BigDecimal value){
        return FuncionarioMapper.toDTO(funcionarioService.aumentaSalario(id,value));
    }
}
