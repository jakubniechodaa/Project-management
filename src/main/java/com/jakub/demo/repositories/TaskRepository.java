package com.jakub.demo.repositories;

import com.jakub.demo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public	interface TaskRepository extends	JpaRepository <Task,Long>	{
    List<Task> findTasksByProjectId(Long id);
}


