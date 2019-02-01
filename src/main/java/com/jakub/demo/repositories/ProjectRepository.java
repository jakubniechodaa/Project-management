package com.jakub.demo.repositories;

import com.jakub.demo.entity.Project;
import com.jakub.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Repository
public	interface ProjectRepository extends	JpaRepository <Project,Long>	{

    Project findProjectsById(Long id);

    List<Project> findProjectsByActive(boolean active);

    List<Project> findProjectsByUsers(User user);
}
