package com.task.TaskManagement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.task.TaskManagement.Entity.TaskModel;
import com.task.TaskManagement.Entity.UserModel;
import com.task.TaskManagement.Services.TaskService;
import com.task.TaskManagement.Services.UserService;

@SpringBootTest
class TaskManagementApplicationTests {

	@Autowired
	UserService userservice;
	@Autowired
	TaskService taskservice;
  @BeforeEach
	public void initDb()
	{
		{
			UserModel user = new UserModel("testuser@gmail.com", "123456", "testuser1");
			userservice.addUser(user);
			
		}
		
		{
			UserModel admin = new UserModel("testadmin@gmail.com", "123456", "testadmin1");
			userservice.addUser(admin);
			
		}
		
		TaskModel task = new TaskModel("you have to work today", "10/11/2020", "0:11", "11:00");
		UserModel user = userservice.getUserWithEmail("testuser@gmail.com");
		taskservice.addTask(task, user);
	}
	
	@Test
	public void testUser()
	{
		
		UserModel user = userservice.getUserWithEmail("testuser@gmail.com");
		assertNotNull(user);
		UserModel admin = userservice.getUserWithEmail("testadmin@gmail.com");
		assertEquals(admin.getEmail(), "testadmin@gmail.com");
		
	}
	@Test
	public void testTask()
	{
		UserModel user=userservice.getUserWithEmail("testuser@gmail.com");
		List<TaskModel>tasks=taskservice.getAllTaskByUser(user);
		assertNotNull(tasks);
	}
	
}
