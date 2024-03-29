package com.Planotech.Employeemangmentsystem.contoroller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Planotech.Employeemangmentsystem.dto.EmployeeManage;
import com.Planotech.Employeemangmentsystem.service.EmployeeManageService;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/employee")
public class EmployeeManageController {
	@Autowired
	EmployeeManageService manageService;
	
	@Autowired
	EmployeeManage employeeManage;
	
	@PostMapping("/signup")
	public String signup(EmployeeManage emp,ModelMap map)
	{	
		return manageService.signup(emp, map);
	}
	@PostMapping("/login")
	public String login(@RequestParam String emph, @RequestParam String password, ModelMap map, HttpSession session) {
		return manageService.login(emph, password, map, session);
	}
}
