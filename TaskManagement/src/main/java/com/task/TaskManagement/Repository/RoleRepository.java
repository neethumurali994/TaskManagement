package com.task.TaskManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.TaskManagement.Entity.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

}
