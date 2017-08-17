package app.serviceImpl;

import app.Utils.ConvertUtil;
import app.dto.ProjectRoleDTO;
import app.entities.ProjectRoleDO;
import app.repo.ProjectRoleRepo;
import app.service.ProjectRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 52400 on 2017/6/21.
 */
@Service
public class ProjectRoleServiceImpl implements ProjectRoleService {

    @Autowired
    private ProjectRoleRepo projectRoleRepo;

    @Autowired
    private ConvertUtil convertUtil;


    @Override
    public List<ProjectRoleDTO> getAllProjectRole() {
        List<ProjectRoleDTO> projectRoleDTOS = new ArrayList<>();
        for(ProjectRoleDO p : projectRoleRepo.findAll()) {
            projectRoleDTOS.add(convertUtil.convertToProjectRoleDTO(p));
        }
        return projectRoleDTOS;
    }
}
