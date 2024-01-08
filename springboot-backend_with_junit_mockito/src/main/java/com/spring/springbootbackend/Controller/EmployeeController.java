package com.spring.springbootbackend.Controller;

import org.slf4j.Logger; 
import java.util.List;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spring.springbootbackend.Model.Employee;
import com.spring.springbootbackend.Services.EmployeeService;
import com.spring.springbootbackend.exception.EmployeeException;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
  
	private static final Logger Logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	EmployeeService employeeService;

	public EmployeeController() {
		super();
	}

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	// http://localhost:8080/api/v1/getByName/{firstName}
	@GetMapping("/getByName/{firstName}")
	public Employee get_Employee_By_firstName(@PathVariable(value = "firstName") String firstName)
			throws EmployeeException {
		return employeeService.get_Employee_By_firstName(firstName);
	}

	// http://localhost:8080/api/v1/getByEmployeeId/{employeeId}
	@GetMapping("/getByEmployeeId/{employeeId}")
	public Employee get_Employee_By_EmployeeId(@PathVariable(value = "employeeId") Long employeeId)
			throws EmployeeException {
		return employeeService.getEmpByEmployeeId(employeeId);
	}

	// Get Mapping for fetching data /working
	// http://localhost:8080/api/v1/employees
	@GetMapping("/employees")
	public List<Employee> getAllEmp() throws EmployeeException {
		Logger.info("*** Get list of employees details....");
		return employeeService.getAllEmployees();

	}

	// Post mapping for adding user data to database /working
//	http://localhost:8080/api/v1/addemployee 
	@PostMapping("/addemployee")
	public Employee addEmployee(@RequestBody Employee employee) throws EmployeeException {
		Logger.info("**** save Employee details ...");
		return employeeService.addEmployee(employee);

	}

//	put mapping for updating data into dataBase/working
//   http://localhost:8080/api/v1/updatingemployee/{id}
	@PutMapping("/updatingemployee/{id}")
	public Employee updateEmployee(@RequestBody Employee employee, @PathVariable(value = "id") Long id)
			throws EmployeeException {
		return employeeService.updateEmployee(employee, id);

	}

//	Delete mapping for deleting data from database/working
//	http://localhost:8080/api/v1/deleteemployee/{id}
	@DeleteMapping("/deleteemployee/{id}")
	public void deleteEmployeeById(@PathVariable(value = "id") Long Id) throws EmployeeException {
		 employeeService.deleteEmployeeById(Id);

	}

//  Get employee by id/working
//	http://localhost:8080/api/v1/employee/{id}
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmpById(@PathVariable(value = "id") Long Id) throws EmployeeException {
		return new ResponseEntity<Employee>(employeeService.getEmpById(Id), HttpStatus.OK);

	}

//  Get employee by id/working / but for failed condition its not throws exception
//	http://localhost:8080/api/v1/employeeEmailId/employeeEmailId
	@GetMapping("/employeeEmailId/{emailId}")
	public Employee getEmpByEmailId(@PathVariable(value = "emailId") String emailId) throws EmployeeException {
		return employeeService.getEmpByEmailId(emailId);

	}

//	get EmployeeByEmialIdAndPassword
//http://localhost:8080/api/v1/employeeIdAndpassword/{employeeId}/{password}
	@GetMapping("/employeeIdAndpassword/{employeeId}/{password}")
	public Employee loginEmployee(@PathVariable(value = "employeeId") Long employeeId,
			@PathVariable(value = "password") String password) throws EmployeeException {
		return employeeService.loginEmployee(employeeId, password);

	}

//	http://localhost:8080/api/v1/authenticate
	@GetMapping("/authenticate")
	public boolean authenticate(@RequestBody Employee employee) throws EmployeeException {
		return employeeService.authenticate(employee);

	}

	// http://localhost:8080/api/v1/changePassword/{id} /working
	@PutMapping("/changePassword/{id}")
	public Employee changePassword(@RequestBody Employee employee, @PathVariable(value = "id") Long id)
			throws EmployeeException {
		return employeeService.changePassword(employee, id);

	}

	// http://localhost:8080/api/v1/forgotPassword/eamilId /working
	@GetMapping("/forgotPassword/{emailId}")
	public Employee forgotPassword(@PathVariable(value = "emailId") String emailId) throws EmployeeException {
		return employeeService.forgotPassword(emailId);

	}

}
