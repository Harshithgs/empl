package com.Planotech.Employeemangmentsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.Planotech.Employeemangmentsystem.dto.MarketingDepartment;
@Component
public interface MarketingDepartmentRepository extends JpaRepository<MarketingDepartment, Integer>{

}
