package com.Planotech.Employeemangmentsystem.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Planotech.Employeemangmentsystem.dto.AccountsDepartment;
import com.Planotech.Employeemangmentsystem.dto.ClientServicingDepartment;
import com.Planotech.Employeemangmentsystem.dto.DesignDepartment;
import com.Planotech.Employeemangmentsystem.dto.EmployeeManage;
import com.Planotech.Employeemangmentsystem.dto.HRDepartment;
import com.Planotech.Employeemangmentsystem.dto.ITDepartment;
import com.Planotech.Employeemangmentsystem.dto.MarketingDepartment;
import com.Planotech.Employeemangmentsystem.dto.ProductionDepartment;
import com.Planotech.Employeemangmentsystem.repository.AccountsDepartmentRepository;
import com.Planotech.Employeemangmentsystem.repository.ClientServicingDepartmentRepository;
import com.Planotech.Employeemangmentsystem.repository.DesignDepartmentRepository;
import com.Planotech.Employeemangmentsystem.repository.EmployeeManageRepository;
import com.Planotech.Employeemangmentsystem.repository.HRDepartmentRepository;
import com.Planotech.Employeemangmentsystem.repository.ITDepartmentRepository;
import com.Planotech.Employeemangmentsystem.repository.MarketingDepartmentRepository;
import com.Planotech.Employeemangmentsystem.repository.ProductionDepartmentRepository;
@Component
public class EmployeeManageDao {
	@Autowired
	EmployeeManageRepository manageRepository;
	@Autowired
	ITDepartmentRepository itDepartmentRepository;
	@Autowired
	AccountsDepartmentRepository accountsDepartmentRepository;
	@Autowired
	ClientServicingDepartmentRepository clientServicingDepartmentRepository;
	@Autowired
	EmployeeManageRepository employeeManageRepository;
	@Autowired
	HRDepartmentRepository hrDepartmentRepository;
	@Autowired
	MarketingDepartmentRepository marketingDepartmentRepository;
	@Autowired
	ProductionDepartmentRepository productionDepartmentRepository;
	@Autowired
	DesignDepartmentRepository departmentRepository;
	
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
	public List<ITDepartment> fetchAllittable() {
		return itDepartmentRepository.findAll();
	}
	public List<HRDepartment> fecthAllhrtable(){
		return hrDepartmentRepository.findAll();
		
	}
	public List<AccountsDepartment> fecthAllaccounttable(){
		return accountsDepartmentRepository.findAll();
		
	}
	public List<ClientServicingDepartment> fecthAllclienttable(){
		return clientServicingDepartmentRepository.findAll();
		
	}
	public List<MarketingDepartment> fecthAllmarket(){
		return marketingDepartmentRepository.findAll();
		
	}
	public List<ProductionDepartment> fecthAllproducts(){
		return productionDepartmentRepository.findAll();
		
	}
	public List<DesignDepartment> fecthAlldesign(){
		return departmentRepository.findAll();
		
	}
	public void saveprofileHR(HRDepartment i) {
		hrDepartmentRepository.save(i); 
	}
	public void saveprofileAccounts(AccountsDepartment i) {
		accountsDepartmentRepository.save(i); 
	}
	public void saveprofileClientS(ClientServicingDepartment i) {
		clientServicingDepartmentRepository.save(i); 
	}
	public void saveprofileMarketing(MarketingDepartment i) {
		marketingDepartmentRepository.save(i); 
	}
	public void saveprofileProduction(ProductionDepartment i) {
		productionDepartmentRepository.save(i); 
	}
	public void saveprofileDesign(DesignDepartment i) {
		departmentRepository.save(i); 
	}
	
	
}
