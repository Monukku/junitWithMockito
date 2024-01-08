package com.spring.springbootbackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.springbootbackend.Model.Department;

public interface DepartmentRepository  extends JpaRepository<Department,Long >{

}
