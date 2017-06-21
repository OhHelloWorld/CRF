package app.service;

import app.dto.ProjectDTO;

import java.util.List;

/**
 * Created by 52400 on 2017/6/21.
 */
public interface ProjectService {

    ProjectDTO addProject(ProjectDTO projectDTO);
    ProjectDTO findProjectById(Long projectId);
    List<ProjectDTO> getProjectByUserId(Long userId);
    void deleteProjectById(Long id);
    ProjectDTO updateProject(ProjectDTO projectDTO);
}
