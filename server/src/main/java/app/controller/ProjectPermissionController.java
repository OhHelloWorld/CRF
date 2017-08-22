package app.controller;

import app.dto.ProjectPermissionDTO;
import app.service.ProjectPermissionServce;
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
@RequestMapping(path = "/api/projectPermission")
@Api(value = "项目角色权限")
public class ProjectPermissionController {

    @Autowired
    private ProjectPermissionServce projectPermissionServce;


    @GetMapping(value = "/project/{projectId}")
    @ApiOperation(value = "得到当前用户在某个项目中的权限")
    public List<ProjectPermissionDTO> getCurrentUserPermissionByProjectId(@PathVariable  @PathParam("项目的id") Long projectId) {
        return projectPermissionServce.getByUserIdAndProjectId(projectId);
    }

}
