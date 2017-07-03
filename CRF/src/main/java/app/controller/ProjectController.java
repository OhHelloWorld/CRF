package app.controller;

import app.dto.*;
import app.service.HospitalService;
import app.service.ProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

    @Autowired
    private HospitalService hospitalService;

    @PostMapping(value = "")
    public ProjectDTO addProject(@RequestBody ProjectDTO projectDTO) {
        return projectService.addProject(projectDTO);
    }

    @DeleteMapping(value = "/{projectId}")
    @ApiOperation(value = "删除项目")
    public void deleteProject(@PathVariable Long projectId) {
        projectService.deleteProject(projectId);
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
    public PageDTO<UserDTO> getUsersInProject(@PathVariable @PathParam("项目id") Long projectId, @PageableDefault(value = 15) Pageable pageable) {
        return projectService.getProjectUser(projectId, pageable);
    }

    @GetMapping(value = "/{projectId}/invUsers")
    @ApiOperation(value = "得到不是这个项目下的user")
    public PageDTO<UserDTO> getUsersNotInProject(@PathVariable Long projectId, @PageableDefault(value = 15) Pageable pageable) {
        return projectService.getProjectNotInUser(projectId, pageable);
    }

    @PostMapping(value = "/acceptInv")
    @ApiOperation(value = "接受邀请")
    public void accpetInvited(@RequestParam Long userId, @RequestParam String projectName) {
        projectService.acceptInvited(userId, projectName);
    }

    @PostMapping(value = "/Inv")
    @ApiOperation(value = "发送邀请")
    public void sendInvited(@RequestParam Long userId, @RequestParam Long projectId, @RequestParam String inviteType) {
        projectService.inviteUser(userId, projectId, inviteType);
    }

    @PostMapping(value = "/rejectInv")
    @ApiOperation(value = "拒绝邀请")
    public void rejectInvited(@RequestParam Long userId, @RequestParam String projectName) {
        projectService.rejectInvited(userId, projectName);
    }


    @GetMapping(value = "/msg")
    @ApiOperation(value = "根据项目名字搜索项目")
    public List<ProjectDTO> getProjetBySearchMsg(@RequestParam String msg) {
        return projectService.getProjectBySearchMsg(msg);
    }

    @GetMapping(value = "")
    @ApiOperation(value = "得到当前用户拥有的项目")
    public List<ProjectDTO> getCurrentUserProject() {
        return projectService.getCurrentUserProjectList();
    }

    @GetMapping(value = "/{projectId}/hospital")
    @ApiOperation(value = "通过某个项目id得到拥有的医院")
    public PageDTO<HospitalDTO> getHospitalsByProjectId(@PathVariable Long projectId, @PageableDefault(value = 15) org.springframework.data.domain.Pageable pageable) {
        return hospitalService.getHospitalByProjectId(projectId, pageable);
    }

    @PostMapping(value = "/demeber")
    @ApiOperation(value = "踢出人员")
    public void rejectInvited(@RequestParam Long userId, @RequestParam Long projectId) {
        projectService.deleteMeber(userId, projectId);
    }

    @PutMapping(value = "/data")
    @ApiOperation(value = "关闭或者开启")
    public void dataCollecrChange(@RequestParam String isCollect, @RequestParam Long projectId) {
        projectService.dataCollectChange(isCollect, projectId);
    }


}
