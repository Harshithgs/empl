package com.Planotech.Employeemangmentsystem.contoroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Planotech.Employeemangmentsystem.service.EmployeeManageService;

import jakarta.servlet.http.HttpSession;

@Controller
public class commoncontroller {
	@Autowired
	EmployeeManageService employeeManageService;

	@GetMapping("/")
	public String loadHome() {
		return "homepage";
	}

	@GetMapping("/about-us")
	public String loadAboutUs() {
		return "AboutUs";
	}

	@GetMapping("/login")
	public String loadLogin() {
		return "login.html";
	}

	@GetMapping("signup")
	public String loadSignup() {
		return "Signup";
	}

	@GetMapping("/profile")
	public String loadprofile(@RequestParam String department,ModelMap map) {
		System.out.println(department);
		map.put("department", department);
		return "Profile.html";
	}

	@PostMapping("/profile")
	public String profile(@RequestParam String username, @RequestParam String email, @RequestParam long phone,
			@RequestParam String address, @RequestParam String department, ModelMap map, HttpSession session) {
		return employeeManageService.profile(username, email, phone, address, department, map, session);
	}
}
