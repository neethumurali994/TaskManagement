package com.task.TaskManagement.Controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.task.TaskManagement.Entity.UserModel;
import com.task.TaskManagement.Services.TaskService;
import com.task.TaskManagement.Services.UserService;

@Controller
public class profileController {
	@Autowired
	UserService userserv;
	@Autowired
	TaskService taskserv;
	
	@GetMapping("/profile")
   public String displayUserProfile(Principal principal,Model model)
	{
		String email = principal.getName();
		UserModel user = userserv.getUserWithEmail(email);
		model.addAttribute("profile", taskserv.getAllTaskByUser(user));
		return "profile";
		
	}

}
