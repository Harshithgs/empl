package com.Planotech.Employeemangmentsystem.contoroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Planotech.Employeemangmentsystem.service.AdminService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminService adminService;
	@GetMapping("/department")
	public String Department(@RequestParam String department,ModelMap map,HttpSession httpSession) {
		System.out.println(department);
		return adminService.Department(department, httpSession, map);
	}
}
