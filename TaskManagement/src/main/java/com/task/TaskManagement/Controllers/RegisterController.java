package com.task.TaskManagement.Controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.task.TaskManagement.Entity.UserModel;
import com.task.TaskManagement.Services.UserService;

@Controller
public class RegisterController {
	@Autowired
	UserService userservice;
	
	@GetMapping("/register")
	public String showRegisterForm(Model model)
	{
		model.addAttribute("usermodel", new UserModel());
		return "Registeration";

	}
	
	@PostMapping("/register")
	public String Registeration(@Valid @ModelAttribute("usermodel") UserModel usermodel, BindingResult bindingresult,Model model)
	{
	   if(bindingresult.hasErrors())
	   {
		   return "Registeration"; 
	   }
	   if(userservice.isUserPresent(usermodel.getEmail()))
	   {
		 model.addAttribute("exist", true); 
		 return "Registeration";
	   }
		userservice.addUser(usermodel);
		return "SuccessRegister";
	}

}
