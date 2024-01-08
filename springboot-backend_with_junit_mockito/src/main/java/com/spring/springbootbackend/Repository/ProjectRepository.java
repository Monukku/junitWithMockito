package com.spring.springbootbackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.springbootbackend.Model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}


