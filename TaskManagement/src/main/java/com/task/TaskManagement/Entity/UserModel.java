package com.task.TaskManagement.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
public class UserModel {

	@Id
	@NotNull
	@Email
	@Column(unique = true)
	private String email;
	@NotNull
	@Size(min = 6)
	private String password;
	private String name;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<TaskModel> tasks;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_role",joinColumns=@JoinColumn(name="user_email", referencedColumnName = "email"),inverseJoinColumns = @JoinColumn(name="role_name", referencedColumnName = "roleName"))
	private List<Role> roles;
	
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<TaskModel> getTasks() {
		return tasks;
	}


	public void setTasks(List<TaskModel> tasks) {
		this.tasks = tasks;
	}


	public List<Role> getRoles() {
		return roles;
	}


	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}


	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", name=" + name + ", tasks=" + tasks + ", roles="
				+ roles + "]";
	}


	public UserModel(String email, String password, String name) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
	}


	public UserModel(String email, String password, String name, List<TaskModel> tasks, List<Role> roles) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.tasks = tasks;
		this.roles = roles;
	}
	public UserModel()
	{
		
	}
	
}
