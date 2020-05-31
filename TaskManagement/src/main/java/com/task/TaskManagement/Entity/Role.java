package com.task.TaskManagement.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import com.sun.istack.NotNull;
@Entity
public class Role {
    @Id
    @NotNull
	private String roleName;
    @ManyToMany(mappedBy = "roles")
	private List<UserModel> users;
	
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public List<UserModel> getUsers() {
		return users;
	}
	public void setUsers(List<UserModel> users) {
		this.users = users;
	}
	@Override
	public String toString() {
		return "Role [roleName=" + roleName + ", users=" + users + "]";
	}
	public Role(String roleName, List<UserModel> users) {
		super();
		this.roleName = roleName;
		this.users = users;
	}
	public Role(String roleName) {
		super();
		this.roleName = roleName;
		
	}
	
	public Role()
	{
		
	}
	
}
