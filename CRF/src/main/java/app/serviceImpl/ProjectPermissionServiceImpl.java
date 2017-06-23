package app.serviceImpl;

import app.Utils.ConvertUtil;
import app.Utils.UserMsgTool;
import app.dto.ProjectPermissionDTO;
import app.entities.ProjectPermissionDO;
import app.repo.ProjectRoleRepo;
import app.repo.UserProjectRoleRepo;
import app.service.ProjectPermissionServce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 52400 on 2017/6/21.
 */

@Service
public class ProjectPermissionServiceImpl implements ProjectPermissionServce {

    @Autowired
    private UserProjectRoleRepo userProjectRoleRepo;

    @Autowired
    private ProjectRoleRepo projectRoleRepo;

    @Autowired
    private ConvertUtil convertUtil;

    @Autowired
    private UserMsgTool tool;


    @Override
    public List<ProjectPermissionDTO> getByUserIdAndProjectId(Long projectId) {
        List<ProjectPermissionDTO> projectPermissionDTOS = new ArrayList<>();
        Long userId = tool.getCurrentUser().getId();
        Long projectRoleId =  userProjectRoleRepo.getRoleId(userId, projectId).getProjectRoleId();
        for(ProjectPermissionDO p : projectRoleRepo.findOne(projectRoleId).getProjectPermissionDOS()) {
            projectPermissionDTOS.add(convertUtil.convertToProjectPermissionDTO(p));
        }
        return projectPermissionDTOS;
    }
}
