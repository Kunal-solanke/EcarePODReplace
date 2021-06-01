package com.example.demo.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.PODModel;
import com.example.demo.service.PODService;



@Controller
public class PODController {
	
	@Autowired
	PODService Podservice;
	

	@RequestMapping("/welcome")
	public String Welcome(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_HOME");
		return "welcomepage";
	}

	@RequestMapping("/register")
	public String registration(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_REGISTER");
		return "welcomepage";
	}

	@PostMapping("/save-user")
	public String registerUser(@ModelAttribute PODModel model, BindingResult bindingResult, HttpServletRequest request) {
		Podservice.saveMyUser(model);
		request.setAttribute("mode", "MODE_HOME");
		return "welcomepage";
	}

	@GetMapping("/show-users")
	public String showAllUsers(HttpServletRequest request) {
		request.setAttribute("users",Podservice.showAllUsers());
		request.setAttribute("mode", "ALL_USERS");
		return "welcomepage";
	}

	@RequestMapping("/delete-user")
	public String deleteUser(@RequestParam int id, HttpServletRequest request) {
		Podservice.deleteMyUser(id);
		request.setAttribute("users", Podservice.showAllUsers());
		request.setAttribute("mode", "ALL_USERS");
		return "welcomepage";
	}
	
	@RequestMapping("/edit-user")
	public String editUser(@RequestParam int id,HttpServletRequest request) {
		request.setAttribute("user", Podservice.editUser(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "welcomepage";
	}
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		
		request.setAttribute("mode", "MODE_LOGIN");
		return "welcomepage";
	}
	
	
	@RequestMapping ("/login-user")
	public String loginUser(@ModelAttribute PODModel model, HttpServletRequest request,HttpServletResponse response)
	{
		
		
		if(Podservice.findByUsernameAndPassword(model.getUsername(), model.getPassword())!=null) 
		{
			return "homepage";
		}
		
		else {
			request.setAttribute("error", "Invalid Username or Password");
			request.setAttribute("mode", "MODE_LOGIN");
			return "welcomepage";
			
		}

	}
	
		

}
