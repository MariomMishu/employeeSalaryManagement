package com.spring5.practice.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring5.practice.model.BasicSalary;
import com.spring5.practice.service.BasicSalaryService;


// For showing index.jsp instead of showing the "not found page" error
@Controller
public class RootController {
	
	@Autowired
	private BasicSalaryService basicSalaryService;

	
	@GetMapping("/")
	public String root() {
		return "index";
	}
	@GetMapping("/basicSalary/add")
	public String add_GET(Model model) {
		model.addAttribute("basicSalary", new BasicSalary());
		model.addAttribute("message", "Please add Basic salary");
		return "basicSalary/add";
	}
	@PostMapping("/basicSalary/update")
	public String add_POST(Model model, @ModelAttribute(name = "bs") BasicSalary bs) {
		basicSalaryService.add(bs);
		model.addAttribute("message", "Basic added successfully");
		return "redirect:/";
	}

}
