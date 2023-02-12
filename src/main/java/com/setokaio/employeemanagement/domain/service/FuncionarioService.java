package com.setokaio.employeemanagement.domain.service;

import com.setokaio.employeemanagement.domain.entity.Departamento;
import com.setokaio.employeemanagement.domain.entity.Funcionario;
import com.setokaio.employeemanagement.domain.exception.FaltaOrcamentoException;
import com.setokaio.employeemanagement.domain.exception.FuncionarioNaoEncontradoException;
import com.setokaio.employeemanagement.domain.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static com.setokaio.employeemanagement.domain.utils.Validation.validaOrcamento;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Funcionario aumentaSalario(Long id, BigDecimal valor){
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(()-> new FuncionarioNaoEncontradoException("Esse funcionário não está em nossa base de dados"));
        Departamento departamento =funcionario.getDepartamento();
        if(validaOrcamento(funcionario.getDepartamento(),valor)) {
            departamento.aumentaTotalSalarios(valor);
            funcionario.aumentaSalario(valor);
            departamento.adicionaFuncionario(funcionario);
            return funcionarioRepository.save(funcionario);
        }
        throw new FaltaOrcamentoException("Orçamento insuficiente para realizar aumento");
    }

}