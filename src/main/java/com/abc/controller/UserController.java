package com.abc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.abc.model.User;
import com.abc.repository.UserRepository;
import com.abc.service.UserService;

@Controller
@RequestMapping("/admin/user")
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/list")
	public String ListUsers(Model model) {
		List<User> listUsers = userService.getList();
		model.addAttribute("users", listUsers);
		return "admin/user/list-users";
	}
	
	@GetMapping("/add")
	public String AddUser(@ModelAttribute("userRequest") User userRequest, Model model) {
		model.addAttribute("userRequest", userRequest);
		return "admin/user/add-user";
	}

	@PostMapping("/add")
	public String save(@ModelAttribute User userRequest) throws IOException {
		try {
			userService.save(userRequest);
		} catch (Exception e) {
		}
		return "redirect:/admin/user/list";
	}
}
