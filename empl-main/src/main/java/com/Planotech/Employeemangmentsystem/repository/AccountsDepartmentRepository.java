package com.Planotech.Employeemangmentsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.Planotech.Employeemangmentsystem.dto.AccountsDepartment;
@Component
public interface AccountsDepartmentRepository extends JpaRepository<AccountsDepartment, Integer>{

}
