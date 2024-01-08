package com.spring.springbootbackend.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spring.springbootbackend.Model.Project;
import com.spring.springbootbackend.Services.ProjectService;
import com.spring.springbootbackend.exception.ProjectException;

@RestController
@RequestMapping("/proj/v1")
public class ProjectController {

	private ProjectService projectService;

	public ProjectController(ProjectService projectService) {
		super();
		this.projectService = projectService;
	}

	@GetMapping("/getByProjectId/{projectId}")
	public Project getProjectById(Long projectId) throws ProjectException {

		return projectService.getProjectById(projectId);
	}

	@PostMapping("/addProject")
	public Project addProject(Project project) throws ProjectException {

		return projectService.addProject(project);
	}

	@PutMapping("/updateProject/{projectId}")
	public Project updateProject(@PathVariable(value = "projectId") Project project, Long projectId)
			throws ProjectException {

		return projectService.updateProject(project, projectId);
	}

	@DeleteMapping("/deleteById/{projectId}")
	public void deleteProject(@PathVariable(value = "projectId") Long projectId) throws ProjectException {

		projectService.deleteProject(projectId);
	}

}
