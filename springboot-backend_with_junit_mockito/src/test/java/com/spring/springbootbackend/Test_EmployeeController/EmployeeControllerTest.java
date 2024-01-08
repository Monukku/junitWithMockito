package com.spring.springbootbackend.Test_EmployeeController;


import com.spring.springbootbackend.Controller.EmployeeController;
import com.spring.springbootbackend.Model.Employee;
import com.spring.springbootbackend.Services.EmployeeService;
import com.spring.springbootbackend.exception.EmployeeException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@SpringBootTest(classes = EmployeeControllerTest.class)
public class EmployeeControllerTest {

    @Mock
    EmployeeService employeeService;
    @InjectMocks
    public EmployeeController employeeController;

    List<Employee>  employee_list;

    @Test
    @Order(1)
    public void Test_get_Employee_By_firstName(){

        Employee employee= new Employee(10L, "donu", "kumar", "do@gmail.com", 12534L, "12553@123", "12553@123");

        when(employeeService.get_Employee_By_firstName(employee.getFirstName())).thenReturn(employee);

        assertEquals(employee,employeeController.get_Employee_By_firstName(employee.getFirstName()));

    }

    @Test
    @Order(2)
    public void Test_get_Employee_By_EmployeeId() throws EmployeeException {

        Employee employee= new Employee(10L, "donu", "kumar", "do@gmail.com", 12534L, "12553@123", "12553@123");

        when(employeeService.getEmpByEmployeeId(employee.getEmployeeId())).thenReturn(employee);

        assertEquals(employee,employeeController.get_Employee_By_EmployeeId(employee.getEmployeeId()));

    }

    @Test
    @Order(3)
    public void Test_getAllEmp() throws EmployeeException {

        employee_list= new ArrayList<Employee>();
        employee_list.add(new Employee(10L, "monu", "kumar", "mo@gmail.com", 1234L, "123@123", "123@123"));
        employee_list.add(new Employee(20L, "sonu", "kumar", "so@gmail.com", 12434L, "1234@123", "1234@123"));
        employee_list.add( new Employee(30L, "donu", "kumar", "do@gmail.com", 12534L, "12553@123", "12553@123"));

        when(employeeService.getAllEmployees()).thenReturn(employee_list);

        assertEquals(employee_list,employeeController.getAllEmp());

    }

    @Test
    @Order(4)
    public void Test_addEmployee() throws EmployeeException {

        Employee employee= new Employee(10L, "donu", "kumar", "do@gmail.com", 12534L, "12553@123", "12553@123");

        when(employeeService.addEmployee(employee)).thenReturn(employee);

        assertEquals(employee,employeeController.addEmployee(employee));

    }

    @Test
    @Order(5)
    public void Test_updateEmployee() throws EmployeeException {

        Employee employee= new Employee(10L, "donu", "kumar", "do@gmail.com", 12534L, "12553@123", "12553@123");

        when(employeeService.updateEmployee(employee,employee.getEmployeeId())).thenReturn(employee);

        assertEquals(employee,employeeController.updateEmployee(employee,employee.getEmployeeId()));

    }

    @Test
    @Order(6)
    public void Test_deleteEmployeeById() throws EmployeeException {

        Employee employee= new Employee(10L, "donu", "kumar", "do@gmail.com", 12534L, "12553@123", "12553@123");

        employeeController.deleteEmployeeById(employee.getEmployeeId());

        verify(employeeService,times(1)).deleteEmployeeById(employee.getEmployeeId()); // Mocking aa well as assertions

    }

    @Test
    @Order(7)
    public void Test_getEmpById() throws EmployeeException {

        Employee employee= new Employee(10L, "donu", "kumar", "do@gmail.com", 12534L, "12553@123", "12553@123");

        when(employeeService.getEmpById(employee.getId())).thenReturn(employee);

        ResponseEntity<Employee>  response= employeeController.getEmpById(employee.getId());

        assertEquals(HttpStatus.OK,response.getStatusCode());

    }

    @Test
    @Order(8)
    public void Test_getEmpByEmailId() throws EmployeeException {

        Employee employee= new Employee(10L, "donu", "kumar", "do@gmail.com", 12534L, "12553@123", "12553@123");

        when(employeeService.getEmpByEmailId(employee.getEmailId())).thenReturn(employee);

        assertEquals(employee,employeeController.getEmpByEmailId(employee.getEmailId()));

    }

    @Test
    @Order(9)
    public void Test_loginEmployee() throws EmployeeException {

        Employee employee= new Employee(10L, "donu", "kumar", "do@gmail.com", 12534L, "12553@123", "12553@123");

        when(employeeService.loginEmployee(employee.getEmployeeId(),employee.getPassword())).thenReturn(employee);

        assertEquals(employee,employeeController.loginEmployee(employee.getEmployeeId(),employee.getPassword()));

    }

    @Disabled
    @Test
    @Order(10)
    public void Test_authenticate() throws EmployeeException {

//        Employee employee= new Employee(10L, "donu", "kumar", "do@gmail.com", 12534L, "12553@123", "12553@123");

//        when(employeeService.authenticate(employee)).thenReturn()

    }

    @Test
    @Order(11)
    public void Test_changePassword(){

        Employee employee= new Employee(10L, "donu", "kumar", "do@gmail.com", 12534L, "12553@123", "12553@123");

        when(employeeService.changePassword(employee,employee.getId())).thenReturn(employee);

        assertEquals(employee,employeeController.changePassword(employee,employee.getId()));

    }

    @Test
    @Order(12)
    public void Test_forgotPassword() throws EmployeeException {

        Employee employee= new Employee(10L, "donu", "kumar", "do@gmail.com", 12534L, "12553@123", "12553@123");

        when(employeeService.forgotPassword(employee.getEmailId())).thenReturn(employee);

        assertEquals(employee,employeeController.forgotPassword(employee.getEmailId()));

    }

}
