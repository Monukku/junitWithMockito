package com.spring.springbootbackend.Services;

import com.spring.springbootbackend.Model.Department;
import com.spring.springbootbackend.exception.DepartmentException;

public interface DepartmentService {

//	public List<Employee> getAllByDepartmentNo(Long departmentNo);
//
//	public List<Employee> getAllByDepartmentLocation(String departmentLocation);
//
//	public List<Employee> getAllByDepartmentName(String departmentName);

	public Department getDepartmentByDeptNo(Long departmentNo) throws DepartmentException;

	public Department addDepartment(Department department) throws DepartmentException;

	public Department updateDepartment(Department department, Long departmentNo) throws DepartmentException;

	public void deleteDeparment(Long departmentNo) throws DepartmentException;

}
