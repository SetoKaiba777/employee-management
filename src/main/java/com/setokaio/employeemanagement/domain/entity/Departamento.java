package com.setokaio.employeemanagement.domain.entity;

import lombok.*;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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

    public void aumentaTotalSalarios(BigDecimal aumento){
        this.totalSalarios = totalSalarios.add(aumento);
    }

    public void adicionaFuncionario(Funcionario funcionario){
        funcionarios.add(funcionario);
    }
}




