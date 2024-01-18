package com.Planotech.Employeemangmentsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.Planotech.Employeemangmentsystem.dao.EmployeeManageDao;
import com.Planotech.Employeemangmentsystem.dto.AccountsDepartment;
import com.Planotech.Employeemangmentsystem.dto.ClientServicingDepartment;
import com.Planotech.Employeemangmentsystem.dto.DesignDepartment;
import com.Planotech.Employeemangmentsystem.dto.EmployeeManage;
import com.Planotech.Employeemangmentsystem.dto.HRDepartment;
import com.Planotech.Employeemangmentsystem.dto.ITDepartment;
import com.Planotech.Employeemangmentsystem.dto.MarketingDepartment;
import com.Planotech.Employeemangmentsystem.dto.ProductionDepartment;

import jakarta.servlet.http.HttpSession;
@Component
@Service
public class EmployeeManageService {
	@Autowired
	EmployeeManageDao manageDao;
	@Autowired
	ITDepartment itDepartment;
	@Autowired
	AccountsDepartment accountsDepartment;
	@Autowired
	ClientServicingDepartment clientServicingDepartment;
	@Autowired
	DesignDepartment designDepartment;
	@Autowired
	MarketingDepartment marketingDepartment;
	@Autowired
	HRDepartment hrDepartment;
	@Autowired
	ProductionDepartment productionDepartment;
	public String signup(EmployeeManage employeeManage, ModelMap map) {
		List<EmployeeManage> oldemp = manageDao.findByEmailOrPhone(employeeManage.getEmail(),
				employeeManage.getPhone());
		System.out.println(oldemp);
		if (!oldemp.isEmpty()) {
			map.put("fail", "Account Already Exixst");
			return "Signup";
		} else {
			manageDao.saveallemp(employeeManage);
			return "Login";
		}
	}

	public String login(String emph, String password, ModelMap map, HttpSession session) {
		if (emph.equals("admin") && password.equals("admin")) {
			session.setAttribute("admin", "admin");
			map.put("pass", "Admin Login Success");
			return "AdminHome";
		} else {
			long mobile = 0;
			String email = null;
			try {
				mobile = Long.parseLong(emph);
			} catch (NumberFormatException e) {
				email = emph;
			}
			List<EmployeeManage> exEmp=manageDao.findByEmailOrPhone(email, mobile);
			if(exEmp.isEmpty()) {
				map.put("fail", "Invalid Email or Mobile");
				return "login.html";
			}else {
				EmployeeManage employeeManage=exEmp.get(0);
				if(employeeManage.getPassword().equals(password)) {
					session.setAttribute("employee", employeeManage);
					map.put("pass", "Login Success");
					if(employeeManage.getDeptarment().equals("IT")) {
						return "ITdepartment.html";
					}else if(employeeManage.getDeptarment().equals("HR")){
						return "HRdepartment.html";
					}else if(employeeManage.getDeptarment().equals("Accounts")) {
						return "Accountsdepartment.html";
					}else if(employeeManage.getDeptarment().equals("Design")) {
						return "Designdepartment.html";
					}else if(employeeManage.getDeptarment().equals("Marketing")) {
						return "Marketingdepartment.html";
					}else if(employeeManage.getDeptarment().equals("Production")) {
						return "Productiondepartment.html";
					}else if(employeeManage.getDeptarment().equals("ClientServicing")) {
						return "ClientServicingdepartment.html";
					}
					else {
						return "login.html";
					}
				}else {
					map.put("fail", "Invalid password");
					return "login.html";
				}
			}
		}
	}
	
	public String profile(String username,String email,long phone,String address ,String department, ModelMap map, HttpSession session) {
		System.out.println(department);
		if(department.equals("IT")) {
			itDepartment.setAddres(address);
			itDepartment.setEmail(email);
			itDepartment.setMobile(phone);
			itDepartment.setUsername(username);
			manageDao.saveprofileIT(itDepartment);
			return "ITdepartment.html";
		}else if(department.equals("Production")) {
			productionDepartment.setAddres(address);
			productionDepartment.setEmail(email);
			productionDepartment.setMobile(phone);
			productionDepartment.setUsername(username);
			manageDao.saveprofileProduction(productionDepartment);
			return "Productiondepartment.html";
		}else if(department.equals("Design")) {
			designDepartment.setAddres(address);
			designDepartment.setEmail(email);
			designDepartment.setMobile(phone);
			designDepartment.setUsername(username);
			manageDao.saveprofileDesign(designDepartment);
			return "Designdepartment.html";
		}else if(department.equals("HR")) {
			hrDepartment.setAddres(address);
			hrDepartment.setEmail(email);
			hrDepartment.setMobile(phone);
			hrDepartment.setUsername(username);
			manageDao.saveprofileHR(hrDepartment);
			return "HRdepartment.html";
		}else if(department.equals("ClientServicing")) {
			clientServicingDepartment.setAddres(address);
			clientServicingDepartment.setEmail(email);
			clientServicingDepartment.setMobile(phone);
			clientServicingDepartment.setUsername(username);
			manageDao.saveprofileClientS(clientServicingDepartment);
			return "ClientServicingdepartment.html";
		}else if(department.equals("Marketing")) {
			marketingDepartment.setAddres(address);
			marketingDepartment.setEmail(email);
			marketingDepartment.setMobile(phone);
			marketingDepartment.setUsername(username);
			manageDao.saveprofileMarketing(marketingDepartment);
			return "Marketingdepartment.html";
		}else if(department.equals("Accounts")) {
			accountsDepartment.setAddres(address);
			accountsDepartment.setEmail(email);
			accountsDepartment.setMobile(phone);
			accountsDepartment.setUsername(username);
			manageDao.saveprofileAccounts(accountsDepartment);
			return "Accountsdepartment.html";
		}
		else {
			return "Profile.html";
		}
	}

	public String dailyReport(String report, ModelMap map, HttpSession session) {
		itDepartment.setReport(report);
		manageDao.saveprofileIT(itDepartment);
		return "ITdepartment";
	}
}
