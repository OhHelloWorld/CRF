package app.controller;

import app.dto.ProjectPermissionDTO;
import app.service.ProjectPermissionServce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 52400 on 2017/6/21.
 */

@RestController
@RequestMapping(path = "/api/projectPermission")
public class ProjectPermissionController {

    @Autowired
    private ProjectPermissionServce projectPermissionServce;


    @GetMapping(value = "/project/{projectId}")
    public List<ProjectPermissionDTO> getCurrentUserPermissionByProjectId(@PathVariable Long projectId) {
        return projectPermissionServce.getByUserIdAndProjectId(projectId);
    }

}
