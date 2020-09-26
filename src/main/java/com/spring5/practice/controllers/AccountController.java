package com.spring5.practice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring5.practice.model.Account;
import com.spring5.practice.service.AccountService;

@Controller
public class AccountController {
	@Autowired
	private AccountService accountService;

	@GetMapping("/account/add")
	public String add_GET(Model model) {
		model.addAttribute("account", new Account());
		return "account/add";
	}
	@PostMapping("/account/add")
	public String add(Model model, @ModelAttribute("account") Account account) {
		accountService.add(account);
		model.addAttribute("message", "New Account Added Successfully");
		return "redirect:/account/show-all";
	}
	@GetMapping("/account/show-all")
	public String show_all(Model model) {
		model.addAttribute("account", new Account());
		model.addAttribute("account_list", accountService.getAll());
		model.addAttribute("message", "Showing All Account");
		return "account/show-all";
	}
	@GetMapping("/account/edit")
	public String edit_GET(Model model, @RequestParam("id") long id) {
		Account account = accountService.getById(id);
		model.addAttribute("account",account);
		return "account/edit";
	}
	@PostMapping("/account/edit")
	public String edit(Model model, @ModelAttribute(name = "account") Account account) {
		System.out.println(account);
		accountService.edit(account);
		model.addAttribute("message", "Account Edited Successfully");
		return "redirect:/account/show-all";
	}

	@GetMapping("/account/delete")
	public String delete_GET(Model model, @RequestParam("id") long id) {
		accountService.delete(id);
		model.addAttribute("message","Account deleted successfully");
		return "redirect:/account/show-all";
	}

}
