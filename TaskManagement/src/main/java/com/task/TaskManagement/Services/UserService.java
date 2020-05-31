package com.task.TaskManagement.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.task.TaskManagement.Entity.Role;
import com.task.TaskManagement.Entity.UserModel;
import com.task.TaskManagement.Repository.TaskRepository;
import com.task.TaskManagement.Repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;
	@Autowired
	TaskRepository taskRepo;
	
	public void addUser(UserModel user)
	{
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		
		Role role = new Role("user");
		List<Role> roles = new ArrayList<Role>();
		roles.add(role);
		user.setRoles(roles);
		
		userRepo.save(user);
	}
	
	public void addAdmin(UserModel admin)
	{
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		admin.setPassword(encoder.encode(admin.getPassword()));
		
		Role role = new Role("admin");
		List<Role> roles = new ArrayList<Role>();
		roles.add(role);
		admin.setRoles(roles);
		
		userRepo.save(admin);
	}
	
	
	public UserModel getUserWithEmail(String email)
	{
		UserModel user = userRepo.findByEmail(email);
	    return user;
	}

	public boolean isUserPresent(String email) {
		UserModel user = userRepo.findByEmail(email);
		if (user != null) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public List<UserModel> getAllUsersByName(String name) {
		// TODO Auto-generated method stub
		List<UserModel> users = userRepo.findByNameLike("%"+name+"%");
		return users;
	}

	

}
