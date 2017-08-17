package app.controller;

import app.dto.ProjectRoleDTO;
import app.service.ProjectRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 52400 on 2017/6/21.
 */

@RestController
@RequestMapping(path = "/api/projectRoles")
@Api(value = "项目角色")
public class ProjectRoleController {


    @Autowired
    private ProjectRoleService projectRoleService;


    @GetMapping(value = "")
    @ApiOperation(value = "得到项目的默认角色")
    public List<ProjectRoleDTO> getAllProjectRoles() {
        return projectRoleService.getAllProjectRole();
    }
}
