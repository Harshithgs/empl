package com.Planotech.Employeemangmentsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import com.Planotech.Employeemangmentsystem.dao.EmployeeManageDao;
import com.Planotech.Employeemangmentsystem.dto.AccountsDepartment;
import com.Planotech.Employeemangmentsystem.dto.ClientServicingDepartment;
import com.Planotech.Employeemangmentsystem.dto.DesignDepartment;
import com.Planotech.Employeemangmentsystem.dto.HRDepartment;
import com.Planotech.Employeemangmentsystem.dto.ITDepartment;
import com.Planotech.Employeemangmentsystem.dto.MarketingDepartment;
import com.Planotech.Employeemangmentsystem.dto.ProductionDepartment;

import jakarta.servlet.http.HttpSession;
@Component
public class AdminService {
	@Autowired
	EmployeeManageDao employeeManageDao;
		 public String Department(String department,HttpSession httpSession,ModelMap map) {
			 //System.out.println(department);
		 if(department.equals("IT")) {
			 List<ITDepartment> list=employeeManageDao.fetchAllittable();
			 map.put("lists", list);
			 return "ittable";
			 }
		 
		 if (department.equals("HR")) {
			 List<HRDepartment> list=employeeManageDao.fecthAllhrtable();
			 map.put("lists", list);
			 return "hrtable";
		}
		 if(department.equals("Accounts")) {
			 List<AccountsDepartment> list=employeeManageDao.fecthAllaccounttable();
			 map.put("lists", list);
			 return "accountstable";
		 }
		 if(department.equals("Marketing")) {
			 List<MarketingDepartment> list=employeeManageDao.fecthAllmarket();
			 map.put("lists", list);
			 return "marketstable";
		 }
		 if(department.equals("ClientServicing")) {
			 List<ClientServicingDepartment> list=employeeManageDao.fecthAllclienttable();
			 map.put("lists", list);
			 return "clienttable";
		 }
		 if(department.equals("Production")) {
			 List<ProductionDepartment> list=employeeManageDao.fecthAllproducts();
			 map.put("lists", list);
			 return "producttable";
		 }
		 if(department.equals("Design")) {
			 List<DesignDepartment> list=employeeManageDao.fecthAlldesign();
			 map.put("lists", list);
			 return "designtable";
		 }
	    else {
			 return "AdminHome.html";
		 }
		 
		 }
}
