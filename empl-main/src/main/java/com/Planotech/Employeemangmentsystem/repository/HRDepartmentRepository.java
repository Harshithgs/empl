package com.Planotech.Employeemangmentsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.Planotech.Employeemangmentsystem.dto.HRDepartment;
@Component
public interface HRDepartmentRepository extends JpaRepository<HRDepartment, Integer>{

}
