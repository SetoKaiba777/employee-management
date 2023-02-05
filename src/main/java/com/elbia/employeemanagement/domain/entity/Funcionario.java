package com.elbia.employeemanagement.domain.entity;

import com.elbia.employeemanagement.domain.constants.EmployeeStatus;
import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


@Data
@Entity
@Table(name = "TB_FUNCIONARIO")
public class Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String cpf;
    private EmployeeStatus status;
    private BigDecimal salario;
    @ManyToOne
    @JoinColumn(name = "id_departamento",referencedColumnName = "id",nullable = false)
    private Departamento departamento;
}
