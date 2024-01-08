package com.spring.springbootbackend.EmployeeControllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;  
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.springbootbackend.Controller.EmployeeController;
import com.spring.springbootbackend.Model.Employee;
import com.spring.springbootbackend.Repository.EmployeeRepository;
import com.spring.springbootbackend.Services.EmployeeService;;

@SpringBootTest(classes = EmployeeController.class)
@AutoConfigureMockMvc

public class SpringbootBackendEmployeeControllerTest {

	@MockBean
	private EmployeeService employeeService;

	@MockBean
	private EmployeeRepository employeeRepository;

	@Mock
	Logger logger;

	@Autowired
	private MockMvc mockMvc; // for calling rest Api methods we have to send Mock http request and for that

	private static ObjectMapper mapper = new ObjectMapper();

	@BeforeEach
	public void setUp() {  
//		Employee emp_1 = new Employee(10L, "monu", "kumar", "mo@gmail.com", 1234L, "123@123", "123@123");
//		Employee emp_2 = new Employee(20L, "sonu", "kumar", "so@gmail.com", 12434L, "1234@123", "1234@123");
//		Employee emp_3 = new Employee(30L, "donu", "kumar", "do@gmail.com", 12534L, "12553@123", "12553@123");
//
//		emp_list = new ArrayList<Employee>(Arrays.asList(emp_1, emp_2, emp_3));

	}

	@Test
	public void get_all_Employees() {

		Employee emp_1 = new Employee(10L, "monu", "kumar", "mo@gmail.com", 1234L, "123@123", "123@123");
		Employee emp_2 = new Employee(20L, "sonu", "kumar", "so@gmail.com", 12434L, "1234@123", "1234@123");
		Employee emp_3 = new Employee(30L, "donu", "kumar", "do@gmail.com", 12534L, "12553@123", "12553@123");

		List<Employee> emp_list = new ArrayList<Employee>(Arrays.asList(emp_1, emp_2, emp_3));

//		Creating Mock object from Mock  employeeRepository and returning 
//		Mockito.when(employeeRepository.findAll()).thenReturn(emp_list);

//		Getting MockObject from Mock employeeService and returning
		Mockito.when(employeeService.getAllEmployees()).thenReturn(emp_list);

		assertEquals(3, employeeService.getAllEmployees().size());

	}

	@Test
	public void get_Emp_By_Id() {

		Employee emp_1 = new Employee(10L, "monu", "kumar", "mo@gmail.com", 1234L, "123@123", "123@123");

//		Mockito.when(employeeRepository.findByEmailId("mo@gmail.com")).thenReturn(emp_1);

		Mockito.when(employeeService.getEmpById(10L)).thenReturn(emp_1);

		assertEquals(emp_1, employeeService.getEmpById(10L));

	}

	@Test
	public void addEmployee() throws Exception {

		Employee emp = new Employee(30L, "Rahman", "das", "ra@gmail.com", 23423L, "1234@1234", "1234@1234");

		Mockito.when(employeeRepository.save(emp)).thenReturn(emp);
		Mockito.when(employeeService.addEmployee(emp)).thenReturn(emp);

		String json = mapper.writeValueAsString(emp);

		MvcResult mvcResult = mockMvc.perform(get("/api/v1/addemployee").contentType(MediaType.APPLICATION_JSON)
				.characterEncoding("utf-8").content(json).accept(MediaType.APPLICATION_JSON)).andReturn();

		String response = mvcResult.getRequest().getContentAsString();
		Employee empl = new ObjectMapper().readValue(response, Employee.class);

		assertEquals(emp.getEmployeeId(), empl.getEmployeeId());
	}

	@Test
	public void updateEmployee() {

		Employee emp_1 = new Employee(10L, "monu", "kumar", "mo@gmail.com", 1234L, "123@123", "123@123");

		emp_1.setFirstName("sonu");
		emp_1.setLastName("kumar");
		emp_1.setEmailId("so@gmail.com");
		emp_1.setEmployeeId(4321L);
		emp_1.setPassword("321@123");
		emp_1.setConfirmPassword("321@123");

		Mockito.when(employeeRepository.saveAndFlush(emp_1)).thenReturn(emp_1);

		Mockito.when(employeeService.updateEmployee(emp_1, 10L)).thenReturn(emp_1);

		assertEquals("321@123", employeeService.updateEmployee(emp_1, 10L).getPassword());

	}

	@Test
	public void getEmpByEmailId() {

		Employee emp_1 = new Employee(20L, "monu", "kumar", "mo@gmail.com", 1234L, "123@123", "123@123");

		Mockito.when(employeeRepository.findByEmailId(emp_1.getEmailId())).thenReturn(emp_1);

		Mockito.when(employeeService.getEmpByEmailId(emp_1.getEmailId())).thenReturn(emp_1);

		assertEquals(emp_1, employeeService.getEmpByEmailId(emp_1.getEmailId()));

	}

	@Test
	public void loginEmployee() {

		Employee emp = new Employee(20L, "monu", "kumar", "mo@gmail.com", 1234L, "123@123", "123@123");

		Mockito.when(employeeRepository.findByEmployeeIdAndPassword(emp.getEmployeeId(), emp.getPassword()))
				.thenReturn(emp);

		Mockito.when(employeeService.loginEmployee(emp.getEmployeeId(), emp.getPassword())).thenReturn(emp);

		assertEquals(emp.getFirstName(),
				employeeService.loginEmployee(emp.getEmployeeId(), emp.getPassword()).getFirstName());

	}

	@Test
	public void changePassword() {

		Employee emp = new Employee(20L, "monu", "kumar", "mo@gmail.com", 1234L, "123@123", "123@123");

		emp.setPassword("146@123");
		emp.setConfirmPassword("146@123");

		employeeRepository.saveAndFlush(emp);

		Mockito.when(employeeRepository.findByEmployeeId(20L)).thenReturn(emp);

		Mockito.when(employeeService.changePassword(emp, 20L)).thenReturn(emp);

		assertEquals("146@123", employeeService.changePassword(emp, 20L).getPassword());
//		System.out.println("verify    ==========================");
		verify(employeeService).changePassword(emp, 20L);

	}

//	@Test
//	public void deleteEmployeeById() {
//
//		Employee emp = new Employee(20L, "monu", "kumar", "mo@gmail.com", 1234L, "123@123", "123@123");
//
//		Mockito.doAnswer("employee has been deleted ")).whemployeeRepository.delete(emp));
//		employeeRepository.delete(emp);
//		
//		assertNull(emp);
//
//	}

}
