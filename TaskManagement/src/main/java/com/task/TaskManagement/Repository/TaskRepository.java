package com.task.TaskManagement.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.TaskManagement.Entity.TaskModel;
import com.task.TaskManagement.Entity.UserModel;

@Repository
public interface TaskRepository extends JpaRepository<TaskModel, Long> {

	List<TaskModel> findByUser(UserModel user);

	

}
