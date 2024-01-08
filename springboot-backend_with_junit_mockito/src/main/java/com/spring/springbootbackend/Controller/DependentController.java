package com.spring.springbootbackend.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spring.springbootbackend.Model.Dependent;
import com.spring.springbootbackend.Services.DependentService;
import com.spring.springbootbackend.exception.DependentException;

@RestController
@RequestMapping("/dependent/v1")
public class DependentController {

	private DependentService dependentService;

	public DependentController(DependentService dependentService) {
		super();
		this.dependentService = dependentService;
	}

	@GetMapping("/getdependent/{dependentId}")
	public Dependent getDependentByDependentId(@PathVariable(value = "dependentId") Long dependentId)
			throws DependentException {

		return dependentService.getDependentByDependentId(dependentId);
	}

	@PostMapping("/addDependent")
	public Dependent addDependent(Dependent dependent) {

		return dependentService.addDependent(dependent);
	}

	@PutMapping("/updateDependent/{dependentId}")
	public Dependent updateDependent(Dependent dependent, Long dependentId) throws DependentException {

		return dependentService.updateDependent(dependent, dependentId);
	}

	@DeleteMapping("/deleteDependent")
	public void deleteDependent(Long dependentId) throws DependentException {

		dependentService.deleteDependent(dependentId);

	}

}
