package com.spring.springbootbackend.Services;

import java.util.List; 
import com.spring.springbootbackend.Model.Employee;
import com.spring.springbootbackend.exception.EmployeeException;

public interface EmployeeService {

	public List<Employee> getAllEmployees() throws EmployeeException;

	public Employee getEmpById(Long id) throws EmployeeException;
	
	public Employee getEmpByEmailId(String emailId) throws EmployeeException;

	public Employee getEmpByEmployeeId(Long employeeId) throws EmployeeException;
	
	public Employee get_Employee_By_firstName(String firstName) throws EmployeeException;

	public Employee addEmployee(Employee employee) throws EmployeeException; 

	public Employee updateEmployee(Employee employee, Long employeeId) throws EmployeeException;

	public Employee loginEmployee(Long employeeId, String password) throws EmployeeException;

	public boolean authenticate(Employee employee) throws EmployeeException;
	
	public Employee forgotPassword(String emailId) throws EmployeeException;

	public Employee changePassword(Employee employee, Long id) throws EmployeeException;

	public void deleteEmployeeById(Long id) throws EmployeeException;

}
