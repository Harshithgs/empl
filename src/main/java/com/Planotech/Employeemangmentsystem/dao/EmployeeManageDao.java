package com.Planotech.Employeemangmentsystem.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Planotech.Employeemangmentsystem.dto.EmployeeManage;
import com.Planotech.Employeemangmentsystem.dto.ITDepartment;
import com.Planotech.Employeemangmentsystem.repository.EmployeeManageRepository;
import com.Planotech.Employeemangmentsystem.repository.ITDepartmentRepository;
@Component
public class EmployeeManageDao {
	@Autowired
	EmployeeManageRepository manageRepository;
	@Autowired
	ITDepartmentRepository itDepartmentRepository;
	public List<EmployeeManage> findByEmailOrPhone(String email,long phone)
	{
		return manageRepository.findByEmailOrPhone(email,phone);
	}
	public void saveallemp(EmployeeManage employeeManage)
	{
		manageRepository.save(employeeManage);
	}
	public void saveprofileIT(ITDepartment i) {
		itDepartmentRepository.save(i); 
	}
}
