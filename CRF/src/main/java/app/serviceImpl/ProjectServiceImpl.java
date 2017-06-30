package app.serviceImpl;

import app.Utils.ConvertUtil;
import app.dto.HospitalDTO;
import app.dto.ProjectDTO;
import app.dto.ProjectUsersDTO;
import app.entities.*;
import app.repo.*;
import app.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.plugin2.message.Message;

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

    @Autowired
    private ProjectRoleRepo projectRoleRepo;

    @Autowired
    private MessageRepo messageRepo;

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
        MessageDO messageDO = new MessageDO();
        ProjectDO projectDO = projectRepo.findOne(projectId);
        messageDO.setContent(projectDO.getProjectName() + "项目向你发出邀请！");
        messageDO.setReceived_user_id(userId);
        messageDO.setRead(false);
        messageRepo.save(messageDO);
        saveInvited(userId, projectId, projectRoleId);
    }

    @Override
    public List<HospitalDTO> getProjectHospitalList(Long projectId) {
        List<HospitalDTO> hospitalDTOS = new ArrayList<>();
        for(HospitalDO h : projectRepo.findOne(projectId).getHospitalList()) {
            hospitalDTOS.add(convertUtil.convertHospitalDTO(h));
        }
        return hospitalDTOS;
    }

    @Override
    public List<ProjectUsersDTO> getUsersInProject(Long projectId) {
        List<ProjectUsersDTO> projectUsersDTOS = new ArrayList<>();
        for(UserProjectRoleDO p : userProjectRoleRepo.findByProjectId(projectId)) {
            ProjectUsersDTO pro = new ProjectUsersDTO();
            pro.setProjectRoleName(projectRoleRepo.findOne(p.getProjectRoleId()).getProjectRoleName());
            pro.setUserName(userRepo.findOne(p.getUserId()).getUserName());
            projectUsersDTOS.add(pro);
        }
        return projectUsersDTOS;
    }

    public void saveInvited(Long userId, Long projectId, Long projectRoleId) {
        UserProjectRoleDO userProjectRoleDO = new UserProjectRoleDO();
        userProjectRoleDO.setProjectId(projectId);
        userProjectRoleDO.setProjectRoleId(projectRoleId);
        userProjectRoleDO.setUserId(userId);
        userProjectRoleDO.setAccept(false);

        ProjectDO projectDO = projectRepo.findOne(projectId);
        UserDO userDO = userRepo.findOne(userId);
        for(HospitalDO h : projectDO.getHospitalList()){
            if(h.getId() == userDO.getHospital().getId()) {
                break;
            }else {
                projectDO.getHospitalList().add(userDO.getHospital());
                projectRepo.save(projectDO);
                userProjectRoleRepo.save(userProjectRoleDO);
            }
        }
    }

    public void acceptInvited(Long userId, String projectName) {
        ProjectDO projectDO = projectRepo.findByProjectName(projectName);
        UserProjectRoleDO p = userProjectRoleRepo.getRoleId(userId, projectDO.getId());
        p.setAccept(true);
        userProjectRoleRepo.save(p);
    }
}
