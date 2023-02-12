package com.setokaio.employeemanagement.domain.repository;

import com.setokaio.employeemanagement.domain.entity.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {


}
