package com.task.TaskManagement.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.TaskManagement.Entity.TaskModel;
import com.task.TaskManagement.Entity.UserModel;
import com.task.TaskManagement.Repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	TaskRepository taskRepo;
	
	public void addTask(TaskModel task, UserModel user)
	{
		task.setUser(user);
		taskRepo.save(task);
		
	}
	
	public List<TaskModel> getAllTaskByUser(UserModel user)
	{
		List<TaskModel> tasklist = taskRepo.findByUser(user);
		return tasklist;
	}
}
