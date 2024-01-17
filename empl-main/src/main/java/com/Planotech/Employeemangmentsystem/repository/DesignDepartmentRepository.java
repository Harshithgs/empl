package com.Planotech.Employeemangmentsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.Planotech.Employeemangmentsystem.dto.DesignDepartment;
@Component
public interface DesignDepartmentRepository extends JpaRepository<DesignDepartment, Integer>{

}
