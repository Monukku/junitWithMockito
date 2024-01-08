package com.spring.springbootbackend.ServicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.springbootbackend.Model.Employee;
import com.spring.springbootbackend.Repository.EmployeeRepository;
import com.spring.springbootbackend.Services.EmployeeService;
import com.spring.springbootbackend.exception.EmployeeException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private  EmployeeRepository employeeRepository;

	public EmployeeServiceImpl() {
		super();

	}

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> getAllEmployees() throws EmployeeException{

		return employeeRepository.findAll();

	}

	@Override
	public Employee addEmployee(Employee employee) throws EmployeeException {

//		add check for username exists in database
		if (employeeRepository.existsByEmaild(employee.getEmailId())) {
			throw new EmployeeException("emailId is already exists!. ");
		}

//		add check for employeeId exists in database
		if (employeeRepository.existsByEmployeeId(employee.getEmployeeId())) {

			throw  new EmployeeException("EmployeeId is already exists!. ");
		}

		return  employeeRepository.save(employee);


	}

	@Override
	public Employee updateEmployee(Employee employee, Long employeeId) throws EmployeeException {

		Employee existingEmployee = employeeRepository.findByEmployeeId(employeeId);

		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmailId(employee.getEmailId());

		Employee upadtedEmployee;
		upadtedEmployee = employeeRepository.save(existingEmployee);

		return upadtedEmployee;

	}

	@Override
	public void deleteEmployeeById(Long id) throws EmployeeException {

       try {
	         Employee emp = employeeRepository.findById(id).orElseThrow(() -> new EmployeeException("Employee details with given user id : " + id + " not found"));
	         employeeRepository.deleteById(emp.getId());
            }catch (Exception e){
	          throw new EmployeeException("failed to delete");
             }
	}

	@Override
	public Employee getEmpById(Long id) throws EmployeeException {

		Employee bean = employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeException("Employee details with given user id : " + id + " not found"));

		return bean;

	}

	@Override
	public Employee getEmpByEmailId(String emailId) throws EmployeeException {

		Employee emp = null;
		try {

			if (emailId != null) {

				emp = employeeRepository.findByEmailId(emailId);
			}

		} catch (Exception e) {
			throw new EmployeeException("employee not found");
		}

		return emp;

	}

	@Override
	public Employee loginEmployee(Long employeeId, String password) throws EmployeeException {

		Employee emp = null;

		try {
			if (employeeId != null && password != null) {
				emp = employeeRepository.findByEmployeeIdAndPassword(employeeId, password);
			}
		} catch (Exception e) {
			throw new EmployeeException(
					"Employee employeeId :  " + employeeId + " and password : " + password + "  is incorrect ");
		}

		return emp;
	}

	public boolean authenticate(Employee employee) throws EmployeeException {
		try {
			Optional<Employee> optionalEmployee = employeeRepository.findById(employee.getEmployeeId());

			if (optionalEmployee.isPresent()) {
				Employee storedEmployee = optionalEmployee.get();

				// Check if the provided password matches the stored password
				return employee.getPassword().equals(storedEmployee.getPassword());
			} else {
				return false; // Employee not found by ID
			}
		} catch (Exception e) {
			throw new EmployeeException("Error authenticating employee: " + e.getMessage());
		}
	}


	@Override
	public Employee changePassword(Employee employee, Long id) throws EmployeeException {

		Employee exisuser = employeeRepository.findById(id).orElseThrow(
				() -> new EmployeeException("Employee id : " + id + "  is incorrect! Please Enter correct id"));

		exisuser.setPassword(employee.getPassword());
		exisuser.setConfirmPassword(employee.getConfirmPassword());

		employeeRepository.save(exisuser);
		return exisuser;

	}

	@Override
	public Employee forgotPassword(String emailId) throws EmployeeException {
		return getEmpByEmailId(emailId);
	}

	@Override
	public Employee get_Employee_By_firstName(String firstName) throws EmployeeException {

		return employeeRepository.findByFirstName(firstName);

	}

	@Override
	public Employee getEmpByEmployeeId(Long employeeId) throws EmployeeException {

		return employeeRepository.findByEmployeeId(employeeId);
	}

}
