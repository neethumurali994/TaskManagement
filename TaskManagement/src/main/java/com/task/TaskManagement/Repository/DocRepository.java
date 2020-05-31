package com.task.TaskManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.TaskManagement.Entity.Doc;
@Repository
public interface DocRepository extends JpaRepository<Doc,Long> {

}
