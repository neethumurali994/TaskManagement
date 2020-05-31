package com.task.TaskManagement.Controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.task.TaskManagement.Entity.TaskModel;
import com.task.TaskManagement.Entity.UserModel;
import com.task.TaskManagement.Services.TaskService;
import com.task.TaskManagement.Services.UserService;

@Controller
public class TaskController {
	@Autowired
	TaskService taskserv;
	@Autowired
	UserService userserv;
	
 @GetMapping("/addtask")
	public String showTaskForm(String email,Model model,HttpSession session)
	{
	  session.setAttribute("email", email);
		model.addAttribute("task", new TaskModel());
		return "AddTask";
	}
 
 @PostMapping("/addtask")
	public String addTask(@Valid @ModelAttribute("task") TaskModel task, BindingResult bindingresult,HttpSession session)
	{
	 if(bindingresult.hasErrors()) {
		 return "AddTask"; 
	 }
	 UserModel user = userserv.getUserWithEmail((String) session.getAttribute("email"));
			 
	 taskserv.addTask(task, user);
		return "successTask";
	}
	
}
