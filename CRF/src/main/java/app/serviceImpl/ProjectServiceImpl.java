package app.serviceImpl;

import app.Utils.ConvertUtil;
import app.dto.HospitalDTO;
import app.dto.ProjectDTO;
import app.entities.HospitalDO;
import app.entities.ProjectDO;
import app.entities.UserDO;
import app.entities.UserProjectRoleDO;
import app.repo.HospitalRepo;
import app.repo.ProjectRepo;
import app.repo.UserProjectRoleRepo;
import app.repo.UserRepo;
import app.service.ProjectService;
import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 52400 on 2017/6/21.
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepo projectRepo;

    @Autowired
    private ConvertUtil convertUtil;

    @Autowired
    private UserProjectRoleRepo userProjectRoleRepo;

    @Autowired
    private HospitalRepo hospitalRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public ProjectDTO addProject(ProjectDTO projectDTO) {
        ProjectDO projectDO = convertUtil.convertToProjectDO(projectDTO);
        return convertUtil.convertToProjectDTO(projectDO);
    }

    @Override
    public ProjectDTO findProjectById(Long projectId) {
        return convertUtil.convertToProjectDTO(projectRepo.findOne(projectId));
    }

    @Override
    public List<ProjectDTO> getProjectByUserId(Long userId) {
        List<ProjectDTO> projectDTOS = new ArrayList<>();
        for(ProjectDO p : projectRepo.getListProject(userId)) {
            projectDTOS.add(convertUtil.convertToProjectDTO(p));
        }
        return projectDTOS;
    }

    @Override
    public void deleteProjectById(Long id) {

    }

    @Override
    public ProjectDTO updateProject(ProjectDTO projectDTO) {
        return null;
    }

    @Override
    public void inviteUser(Long userId, Long projectId, Long projectRoleId) {
        UserProjectRoleDO userProjectRoleDO = new UserProjectRoleDO();
        userProjectRoleDO.setProjectId(projectId);
        userProjectRoleDO.setProjectRoleId(projectRoleId);
        userProjectRoleDO.setUserId(userId);

        ProjectDO projectDO = projectRepo.findOne(projectId);
        UserDO userDO = userRepo.findOne(userId);
        for(HospitalDO h : projectDO.getHospitalList()){
            if(h.getId() == userDO.getHospital().getId()) {
                break;
            }else {
                projectDO.getHospitalList().add(userDO.getHospital());
                projectRepo.save(projectDO);
            }
        }
        userProjectRoleRepo.save(userProjectRoleDO);
    }

    @Override
    public List<HospitalDTO> getProjectHospitalList(Long projectId) {
        List<HospitalDTO> hospitalDTOS = new ArrayList<>();
        for(HospitalDO h : projectRepo.findOne(projectId).getHospitalList()) {
            hospitalDTOS.add(convertUtil.convertHospitalDTO(h));
        }
        return hospitalDTOS;
    }
}
