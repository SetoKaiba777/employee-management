package com.elbia.employeemanagement.app.controller;

import com.elbia.employeemanagement.app.dto.output.FuncionarioOutputDTO;
import com.elbia.employeemanagement.domain.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

import static com.elbia.employeemanagement.core.mapper.FuncionarioMapper.*;

@RestController
@RequestMapping("/v1/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PutMapping("/{id}")
    private FuncionarioOutputDTO aumentaSalario(@PathVariable("id") Long id, @RequestBody BigDecimal value){
        return toDTO(funcionarioService.aumentaSalario(id,value));
    }
}
