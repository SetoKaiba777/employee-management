package com.elbia.employeemanagement.app.dto.input;

import com.elbia.employeemanagement.domain.entity.Funcionario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
public class DepartamentoInputDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank
    private String nome;
    @NotBlank
    private String descricao;
    @NotNull
    private BigDecimal budget;

}




