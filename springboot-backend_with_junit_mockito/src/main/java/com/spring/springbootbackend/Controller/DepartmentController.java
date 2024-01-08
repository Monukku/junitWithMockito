package com.spring.springbootbackend.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spring.springbootbackend.Model.Department;
import com.spring.springbootbackend.Services.DepartmentService;
import com.spring.springbootbackend.exception.DepartmentException;

@RestController
@RequestMapping("/department/v1")
public class DepartmentController {

	private DepartmentService departmentService;

	public DepartmentController(DepartmentService departmentService) {
		super();
		this.departmentService = departmentService;
	}

	@GetMapping("/getDepartmentNo/{departmentNo}")
	public Department getDepartmentByDeptNo(@PathVariable(value = "departmentNo") Long departmentNo)
			throws DepartmentException {

		return departmentService.getDepartmentByDeptNo(departmentNo);
	}

	@PostMapping("/addDepartment")
	public Department addDepartment(Department department) throws DepartmentException {

		return departmentService.addDepartment(department);
	}

	@PutMapping("/update/{departmentNo}")
	public Department updateDepartment(Department department, @PathVariable(value = "departmentNo") Long departmentNo)
			throws DepartmentException {

		return departmentService.updateDepartment(department, departmentNo);
	}

	@DeleteMapping("/delete/{departmentNo}")
	public void deleteDeparment(Long departmentNo) throws DepartmentException {

		departmentService.deleteDeparment(departmentNo);

	}

}
