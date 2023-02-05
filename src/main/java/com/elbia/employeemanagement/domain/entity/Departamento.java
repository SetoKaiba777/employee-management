package com.elbia.employeemanagement.domain.entity;

import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "TB_DEPARTAMENTO")
public class Departamento implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String descricao;
    private BigDecimal budget;
    private BigDecimal totalSalarios;
    @OneToMany(mappedBy = "departamento",cascade = CascadeType.ALL)
    private List<Funcionario> funcionarios;
}
