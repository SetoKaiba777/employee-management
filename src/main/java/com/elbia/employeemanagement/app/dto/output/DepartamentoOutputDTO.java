package com.elbia.employeemanagement.app.dto.output;

import com.elbia.employeemanagement.domain.entity.Funcionario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Builder
@Data
public class DepartamentoOutputDTO {

    private long id;
    private String nome;
    private String descricao;
    private BigDecimal budget;
    private BigDecimal totalSalarios;

    private List<FuncionarioOutputDTO> funcionarios;
}




