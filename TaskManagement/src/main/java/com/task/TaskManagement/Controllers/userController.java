package com.task.TaskManagement.Controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.task.TaskManagement.Entity.UserModel;
import com.task.TaskManagement.Services.UserService;

@Controller
public class userController {
	@Autowired
	UserService userservice;

	@GetMapping("/allUsers")
	public String getAllUsers(Model model, @RequestParam(defaultValue = "") String name) {
		List<UserModel> listOfUsers = userservice.getAllUsersByName(name);
		model.addAttribute("listOfUsers", listOfUsers);
		return "AllUsers";

	}
	
 
}
