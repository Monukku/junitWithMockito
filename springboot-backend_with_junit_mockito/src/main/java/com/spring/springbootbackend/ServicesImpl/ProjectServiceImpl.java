package com.spring.springbootbackend.ServicesImpl;

import org.springframework.stereotype.Service;
import com.spring.springbootbackend.Model.Project;
import com.spring.springbootbackend.Repository.ProjectRepository;
import com.spring.springbootbackend.Services.ProjectService;
import com.spring.springbootbackend.exception.ProjectException;

@Service
public class ProjectServiceImpl implements ProjectService {

	private final ProjectRepository projectRepository;

	public ProjectServiceImpl(ProjectRepository projectRepository) {
		super();
		this.projectRepository = projectRepository;
	}

	@Override
	public Project getProjectById(Long projectId) throws ProjectException{

		return projectRepository.findById(projectId).orElseThrow(
				() -> new ProjectException("Project with given ProjectId " + projectId + "doesnot exist "));
	}

	@Override
	public Project addProject(Project project) throws ProjectException {

		return projectRepository.saveAndFlush(project);
	}

	@Override
	public Project updateProject(Project project, Long projectId) throws ProjectException{

		Project existingPro = projectRepository.findById(projectId).orElseThrow(
				() -> new ProjectException("Project with given ProjectId " + projectId + "doesnot exist "));
		existingPro.setProjectId(project.getProjectId());
		existingPro.setProjectName(project.getProjectName());
		existingPro.setProjectLocation(project.getProjectLocation());

		Project updatedProject = projectRepository.saveAndFlush(existingPro);

		return updatedProject;
	}

	@Override  
	public void deleteProject(Long projectId) throws ProjectException{

		try {
			projectRepository.deleteById(projectId);
		} catch (Exception e) {
			throw new ProjectException("Project with given ProjectId " + projectId + "doesnot exist ");
		}

	}
}
