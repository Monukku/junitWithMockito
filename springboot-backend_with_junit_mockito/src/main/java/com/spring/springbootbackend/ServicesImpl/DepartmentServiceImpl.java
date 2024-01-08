package com.spring.springbootbackend.ServicesImpl;

import org.springframework.stereotype.Service;
import com.spring.springbootbackend.Model.Department;
import com.spring.springbootbackend.Repository.DepartmentRepository;
import com.spring.springbootbackend.Services.DepartmentService;
import com.spring.springbootbackend.exception.DepartmentException;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	private final DepartmentRepository departmentRepository;

	public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
		super();
		this.departmentRepository = departmentRepository;
	}

	@Override
	public Department getDepartmentByDeptNo(Long departmentNo) throws DepartmentException {
		Department dept = departmentRepository.findById(departmentNo).get();
		return dept;
	}

	@Override
	public Department addDepartment(Department department) throws DepartmentException {

		return departmentRepository.saveAndFlush(department);
	}

	@Override
	public Department updateDepartment(Department department, Long departmentNo) throws DepartmentException {

		Department existingdept = departmentRepository.findById(departmentNo).get();

		existingdept.setDepartmentLocation(department.getDepartmentLocation());
		existingdept.setDepartmentName(department.getDepartmentName());
		existingdept.setDepartmentNo(department.getDepartmentNo());

//		updating department
		Department updatedDept = departmentRepository.saveAndFlush(existingdept);

		return updatedDept;
	}

	@Override
	public void deleteDeparment(Long departmentNo) throws DepartmentException {

		try {
			departmentRepository.deleteById(departmentNo);
		} catch (DepartmentException e) {
			throw new DepartmentException("employee with the given departmentNo " + departmentNo + " doesnot exist ");
		}

	}

}
