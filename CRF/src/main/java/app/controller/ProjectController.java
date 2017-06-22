package app.controller;

import app.dto.HospitalDTO;
import app.dto.ProjectDTO;
import app.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by 52400 on 2017/6/21.
 */

@RestController
@RequestMapping(path = "/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping(value = "")
    public ProjectDTO addProject(@RequestBody ProjectDTO projectDTO) {
        return projectService.addProject(projectDTO);
    }

    @DeleteMapping(value = "/{projectId}")
    public void deleteProject(@PathVariable Long projectId) {
        projectService.deleteProjectById(projectId);
    }

    @PatchMapping(value = "")
    public ProjectDTO updateProject(@RequestBody ProjectDTO projectDTO) {
        return projectService.updateProject(projectDTO);
    }

    @GetMapping(value = "/{projectId}")
    public ProjectDTO getProjectById(@PathVariable Long projectId) {
        return projectService.findProjectById(projectId);
    }

    @GetMapping(value = "/user/{userId}")
    public List<ProjectDTO> getProjectByUserId(@PathVariable Long userId) {
        return projectService.getProjectByUserId(userId);
    }

    @GetMapping(value = "/hospitals/{projectId}")
    public List<HospitalDTO> getProjectHospitalList(@PathVariable Long projectId) {
        return projectService.getProjectHospitalList(projectId);
    }

}
