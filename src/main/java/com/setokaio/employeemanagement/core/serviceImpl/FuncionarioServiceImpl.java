package com.setokaio.employeemanagement.core.serviceImpl;

import com.setokaio.employeemanagement.domain.entity.Departamento;
import com.setokaio.employeemanagement.domain.entity.Funcionario;
import com.setokaio.employeemanagement.domain.exception.FaltaOrcamentoException;
import com.setokaio.employeemanagement.domain.exception.FuncionarioNaoEncontradoException;
import com.setokaio.employeemanagement.domain.repository.FuncionarioRepository;
import com.setokaio.employeemanagement.domain.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static com.setokaio.employeemanagement.core.utils.Validation.validaOrcamento;

@Service
@Primary
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
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
