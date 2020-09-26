package com.spring5.practice.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring5.practice.model.BasicSalary;
import com.spring5.practice.model.Employee;
import com.spring5.practice.service.BasicSalaryService;
import com.spring5.practice.service.EmployeeService;


@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	BasicSalaryService basicSalaryService;
	

	@GetMapping("/employee/add")
	public String add_GET(Model model) {
		model.addAttribute("employee", new Employee());
		return "employee/add";
	}
	@PostMapping("/employee/add")
	public String add(Model model, @ModelAttribute("employee") Employee employee) {
		employeeService.add(employee);
		model.addAttribute("message", "New Employee Added Successfully");
		return "redirect:/employee/show-all";
	}
	@GetMapping("/employee/show-all")
	public String show_all(Model model) {
		model.addAttribute("employee", new Employee());
		model.addAttribute("employee_list", employeeService.getAll());
		model.addAttribute("message", "Showing All Employee");
		return "employee/show-all";
	}
	@GetMapping("/employee/show-salary")
	public String show_salary(Model model) {
		model.addAttribute("employee", new Employee());
		List<BasicSalary> basic_list = new ArrayList<BasicSalary>();
		basic_list = basicSalaryService.getAll();
		model.addAttribute("salary", basic_list.get(0).getBasicSalary());
		model.addAttribute("employee_list", employeeService.getAll());
		model.addAttribute("message", "Showing All Employee");
		return "account/show-salary";
	}

	@GetMapping("/employee/edit")
	public String edit_GET(Model model, @RequestParam("id") long id) {
		Employee employee = employeeService.getById(id);
		model.addAttribute("employee",employee);
		return "employee/edit";
	}
	@PostMapping("/employee/edit")
	public String edit(Model model, @ModelAttribute(name = "employee") Employee employee) {
		employeeService.edit(employee);
		model.addAttribute("message", "Employee Edited Successfully");
		return "redirect:/employee/show-all";
	}

	@GetMapping("/employee/delete")
	public String delete_GET(Model model, @RequestParam("id") long id) {
		employeeService.delete(id);
		model.addAttribute("message","Employee deleted successfully");
		return "redirect:/employee/show-all";
	}
}
