package com.task.TaskManagement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.TaskManagement.Entity.UserModel;


@Repository
public interface UserRepository extends JpaRepository<UserModel, String> {
	UserModel findByEmail(String email);

	
	List<UserModel> findByNameLike(String name);
}
