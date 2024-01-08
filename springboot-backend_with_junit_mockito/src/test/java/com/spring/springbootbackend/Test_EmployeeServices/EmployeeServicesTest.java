package com.spring.springbootbackend.Test_EmployeeServices;

import com.spring.springbootbackend.Model.Employee;
import com.spring.springbootbackend.Repository.EmployeeRepository;
import com.spring.springbootbackend.ServicesImpl.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@SpringBootTest(classes = EmployeeServicesTest.class)
public class EmployeeServicesTest {


    @Mock
    EmployeeRepository employeeRepository;

    @InjectMocks
    EmployeeServiceImpl employeeService;

    public List<Employee> employees;


    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);

        employees = new ArrayList<>();
        employees.add(new Employee(10L, "monu", "kumar", "mo@gmail.com", 1234L, "123@123", "123@123"));
        employees.add(new Employee(20L, "sonu", "kumar", "so@gmail.com", 12434L, "1234@123", "1234@123"));
        employees.add(new Employee(30L, "donu", "kumar", "do@gmail.com", 12534L, "12553@123", "12553@123"));
    }

    @Test
    @Order(1)
    public void Test_getAllEmployees(){

        when(employeeRepository.findAll()).thenReturn(employees); // mocking findAll() employees data

        assertEquals(3,employeeService.getAllEmployees().size());

    }

    @Test
    @Order(2)
    public void Test_addEmployee(){

        Employee employee= new Employee(30L, "donu", "kumar", "do@gmail.com", 12534L, "12553@123", "12553@123");

        when(employeeRepository.save(employee)).thenReturn(employee);

        assertEquals(employee,employeeService.addEmployee(employee));

    }


    @Test
    @Order(3)
    public void Test_updateEmployee() throws  Exception{

        Employee employee=new Employee(30L, "donu", "kumar", "do@gmail.com", 12534L, "12553@123", "12553@123");

        when(employeeRepository.findByEmployeeId(employee.getEmployeeId())).thenReturn(employee);
        when(employeeRepository.save(employee)).thenReturn(employee);

        assertEquals(employee,employeeService.updateEmployee(employee,employee.getEmployeeId()));

    }

    @Test
    @Order(4)
    public void Test_deleteEmployeeById(){
          Employee employee = new Employee(10L, "donu", "kumar", "do@gmail.com", 12534L, "12553@123", "12553@123");

          when(employeeRepository.findById(employee.getId())).thenReturn(Optional.of(employee));

          employeeService.deleteEmployeeById(employee.getId());

          verify(employeeRepository,times(1)).deleteById(employee.getId());  // mocking as well as assertions
    }

    @Test
    @Order(5)
    public  void Test_getEmpById(){

         Employee employee= new Employee(10L, "donu", "kumar", "do@gmail.com", 12534L, "12553@123", "12553@123");

         when(employeeRepository.findById(employee.getId())).thenReturn(Optional.of(employee));

         assertEquals(employee,employeeService.getEmpById(employee.getId()));

    }

    @Test
    @Order(6)
    public void Test_getEmpByEmailId(){

        Employee employee= new Employee(10L, "donu", "kumar", "do@gmail.com", 12534L, "12553@123", "12553@123");

        when(employeeRepository.findByEmailId(employee.getEmailId())).thenReturn(employee);

        assertEquals(employee,employeeService.getEmpByEmailId(employee.getEmailId()));

    }

    @Test
    @Order(7)
    public  void Test_loginEmployee(){

        Employee employee= new Employee(10L, "donu", "kumar", "do@gmail.com", 12534L, "12553@123", "12553@123");

        when(employeeRepository.findByEmployeeIdAndPassword(employee.getEmployeeId(),employee.getPassword())).thenReturn(employee);

        assertEquals(employee,employeeService.loginEmployee(employee.getEmployeeId(),employee.getPassword()));


    }

    @Test
    @Order(8)
    public void Test_authenticate(){
        Employee inputEmployee= new Employee(10L, "donu", "kumar", "do@gmail.com", 12534L, "12553@123", "12553@123");

    // Mocking the behavior of findById
        when(employeeRepository.findById(inputEmployee.getEmployeeId())).thenReturn(Optional.of(inputEmployee));

        // Act
        boolean result = employeeService.authenticate(inputEmployee);

        // Assert
        assertTrue(result);
    }

    @Test
    @Order(9)
    public void Test_get_Employee_By_firstName(){

        Employee employee= new Employee(10L, "donu", "kumar", "do@gmail.com", 12534L, "12553@123", "12553@123");

        when(employeeRepository.findByFirstName(employee.getFirstName())).thenReturn(employee);

        assertEquals(employee,employeeService.get_Employee_By_firstName(employee.getFirstName()));

    }

    @Test
    @Order(10)
    public void Test_getEmpByEmployeeId(){

        Employee employee= new Employee(10L, "donu", "kumar", "do@gmail.com", 12534L, "12553@123", "12553@123");


        when(employeeRepository.findByEmployeeId(employee.getEmployeeId())).thenReturn(employee);

        assertEquals(employee,employeeService.getEmpByEmployeeId(employee.getEmployeeId()));


    }

    @Test
    @Order(11)
    public void Test_changePassword(){

        Employee employee= new Employee(10L, "donu", "kumar", "do@gmail.com", 12534L, "12553@123", "12553@123");

        when(employeeRepository.findById(employee.getId())).thenReturn(Optional.of(employee));

        when(employeeRepository.save(employee)).thenReturn(employee);

        assertEquals(employee,employeeService.changePassword(employee,employee.getId()));

    }


    @Test
    @Order(12)
    public  void Test_forgotPassword(){

        Employee employee= new Employee(10L, "donu", "kumar", "do@gmail.com", 12534L, "12553@123", "12553@123");

        when(employeeRepository.findByEmailId(employee.getEmailId())).thenReturn(employee);

        assertEquals(employee,employeeService.forgotPassword(employee.getEmailId()));

    }

}
