package com.example.service;

import java.util.List;

import com.example.model.Project;

public interface ProjectService {

	public List<Project> listProjects();

	public Project addProject(Project project);

}
