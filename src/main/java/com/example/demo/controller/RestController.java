package com.example.demo.controller;


	
	

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.PODModel;
import com.example.demo.service.PODService;

	

	@org.springframework.web.bind.annotation.RestController
	public class RestController {
		
		@Autowired
		private PODService userService;

		@GetMapping("/")
		public String hello() {
			return "This is Home page";
		}
		
		@GetMapping("/saveuser")
		public String saveUser(@RequestParam String username, @RequestParam String firstname, @RequestParam String lastname, @RequestParam int age, @RequestParam String password) {
			PODModel model = new PODModel(username, firstname, lastname, age, password);
			userService.saveMyUser(model);
			return "User Saved";
		}
	}


