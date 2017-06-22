package app.controller;

import app.dto.ProjectRoleDTO;
import app.service.ProjectRoleService;
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
public class ProjectRoleController {


    @Autowired
    private ProjectRoleService projectRoleService;


    @GetMapping(value = "")
    public List<ProjectRoleDTO> getAllProjectRoles() {
        return projectRoleService.getAllProjectRole();
    }
}
