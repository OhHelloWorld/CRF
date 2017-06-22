package app.controller;

import app.dto.HospitalDTO;
import app.dto.ProjectDTO;
import app.dto.ProjectUsersDTO;
import app.service.ProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Created by 52400 on 2017/6/21.
 */

@RestController
@RequestMapping(path = "/api/projects")
@Api(value = "项目")
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
    @ApiOperation(value = "根据项目id得到一个项目")
    public ProjectDTO getProjectById(@PathVariable @PathParam("项目id") Long projectId) {
        return projectService.findProjectById(projectId);
    }

    @GetMapping(value = "/user/{userId}")
    @ApiOperation(value = "根据用户的id得到用户拥有的项目")
    public List<ProjectDTO> getProjectByUserId(@PathVariable @PathParam("用户的id") Long userId) {
        return projectService.getProjectByUserId(userId);
    }

    @GetMapping(value = "/{projectId}/hospitals/")
    @ApiOperation(value = "根据项目的id得到该项目的医院")
    public List<HospitalDTO> getProjectHospitalList(@PathVariable @PathParam("项目的id") Long projectId) {
        return projectService.getProjectHospitalList(projectId);
    }

    @GetMapping(value = "/{projectId}/users")
    @ApiOperation(value = "根据projectId得到项目下面的用户")
    public List<ProjectUsersDTO> getUsersInProject(@PathVariable @PathParam("项目id") Long projectId) {
        return projectService.getUsersInProject(projectId);
    }
}
