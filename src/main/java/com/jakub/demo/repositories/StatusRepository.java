package com.jakub.demo.repositories;

import com.jakub.demo.entity.Status;
import com.jakub.demo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public	interface StatusRepository extends	JpaRepository <Status,Long>	{

    List<Status> findAllByActive(boolean active);
}


