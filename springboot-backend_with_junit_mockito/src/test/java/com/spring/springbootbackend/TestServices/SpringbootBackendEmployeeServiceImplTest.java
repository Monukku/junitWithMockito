package com.spring.springbootbackend.TestServices;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import com.spring.springbootbackend.Model.Employee;
import com.spring.springbootbackend.Repository.EmployeeRepository;
import com.spring.springbootbackend.Services.EmployeeService;
import com.spring.springbootbackend.ServicesImpl.EmployeeServiceImpl;

@SpringBootTest(classes = EmployeeServiceImpl.class)
public class SpringbootBackendEmployeeServiceImplTest {

	static class EmployeeServiceImplTestContextConfiguration {
		@Bean
		private EmployeeService employeeService() {
			return new EmployeeServiceImpl();
		}
	}

	@Autowired
	private EmployeeService employeeService;

	@MockBean
	private EmployeeRepository employeeRepository;

	private Employee employee;

	@SuppressWarnings("unused")
	private List<Employee> emp_list, emp_list1;

	@BeforeEach
	public void setUp() {

		employee = new Employee();
		employee.setId(10L);
		employee.setFirstName("monu");
		employee.setLastName("singh");
		employee.setEmailId("mo@gmail.com");
		employee.setEmployeeId(1234L);
		employee.setPassword("123@123");
		employee.setConfirmPassword("123@123");

		Employee emp_1 = new Employee(10L, "monu", "kumar", "mo@gmail.com", 1234L, "123@123", "123@123");
		Employee emp_2 = new Employee(20L, "sonu", "kumar", "so@gmail.com", 12434L, "1234@123", "1234@123");
		Employee emp_3 = new Employee(30L, "donu", "kumar", "do@gmail.com", 12534L, "12553@123", "12553@123");

		emp_list = new ArrayList<>(Arrays.asList(emp_1, emp_2, emp_3));

		Employee e1 = new Employee(10L, "monu", "kumar", "mo@gmail.com", 1234L, "123@123", "123@123");
		Employee e2 = new Employee(20L, "sonu", "kumar", "so@gmail.com", 12434L, "1234@123", "1234@123");
		Employee e3 = new Employee(30L, "donu", "kumar", "do@gmail.com", 12534L, "12553@123", "12553@123");

		emp_list1 = new ArrayList<>(Arrays.asList(e1, e2, e3));

//		mocking object from employeeRepository.
//		======================================================================

		Mockito.when(employeeRepository.findByFirstName(employee.getFirstName())).thenReturn(employee);

//		====================================================================================>

		Mockito.when(employeeRepository.findByEmailId(employee.getEmailId())).thenReturn(
				emp_list.stream().filter((emp) -> emp.getEmailId().equals(employee.getEmailId())).findAny().get());

//		=====================================================================>

		Mockito.when(employeeRepository.findAll()).thenReturn(emp_list);

//		=============================================================================>

		Mockito.when(employeeRepository.findByEmployeeIdAndPassword(e1.getEmployeeId(), e1.getPassword()))
				.thenReturn(e1);

// ====================================================================

	}

	@Test
	public void Test_whenValidName_thenReturn_Employee() {

//		Employee emp = new Employee(10L, "monu", "singh", "mo@gmail.com", 1234L, "123@123", "123@123");

		String firstName = "monu";
		String lastName = "singh";
		Employee emp = employeeService.get_Employee_By_firstName(firstName);

		assertEquals(firstName, emp.getFirstName());
		assertEquals(lastName, emp.getLastName());

	}

	@Test
	public void Test_get_Employee_ByEmailId() {

		String employee_EmailId = "mo@gmail.com";

		Employee emp = employeeService.getEmpByEmailId(employee_EmailId);

		assertEquals(employee_EmailId, emp.getEmailId());

	}

	@Test
	public void Test_get_All_Employees() {

		List<Employee> emplist1 = employeeService.getAllEmployees();

		assertEquals(emp_list, emplist1);

	}

	@Test
	public void Test_Login_Employee_By_EmployeeId_And_Password() {
		Long employeeId = 1234L;
		String pass = "123@123";
		Employee empl = employeeService.loginEmployee(employeeId, pass);

		assertEquals(employeeId, empl.getEmployeeId());
		assertEquals(pass, empl.getPassword());

	}

	@Test
	public void Test_changePassword() {
		String password = "new@Password";
		employee.setPassword(password);
		employee.setConfirmPassword(password);

		assertEquals(password, employee.getPassword());

	}

}
