package com.Planotech.Employeemangmentsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.Planotech.Employeemangmentsystem.dto.ProductionDepartment;
@Component
public interface ProductionDepartmentRepository extends JpaRepository<ProductionDepartment, Integer>{

}
