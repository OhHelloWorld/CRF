package app.serviceImpl;

import app.Utils.ConvertUtil;
import app.Utils.UserMsgTool;
import app.dto.*;
import app.entities.*;
import app.repo.*;
import app.service.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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

    // @Autowired
    // private HospitalRepo hospitalRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ProjectRoleRepo projectRoleRepo;

    @Autowired
    private MessageRepo messageRepo;

    @Autowired
    private UserMsgTool userMsgTool;

    @Override
    public void addProject(ProjectDTO projectDTO) {
        ProjectDO projectDO = projectRepo.save(convertToDO(projectDTO));
        UserProjectRoleDO userProjectRoleDO = new UserProjectRoleDO();
        userProjectRoleDO.setAccept(true);
        userProjectRoleDO.setProjectId(projectDO.getId());
        userProjectRoleDO.setUserId(userMsgTool.getCurrentUserId());
        userProjectRoleDO.setProjectRoleId(1L);
        userProjectRoleRepo.save(userProjectRoleDO);
    }

    @Override
    public ProjectDTO findProjectById(Long projectId) {
        return convertUtil.convertToProjectDTO(projectRepo.findOne(projectId));
    }

    @Override
    public List<ProjectDTO> getProjectByUserId(Long userId) {
        List<ProjectDTO> projectDTOS = new ArrayList<>();
        for (ProjectDO p : projectRepo.getListProject(userId)) {
            projectDTOS.add(convertUtil.convertToProjectDTO(p));
        }
        return projectDTOS;
    }

    @Override
    public ProjectDTO updateProject(ProjectDTO projectDTO) {
        return null;
    }

    @Override
    public void inviteUser(Long userId, Long projectId, String inviteType) {
        MessageDO messageDO = new MessageDO();
        ProjectDO projectDO = projectRepo.findOne(projectId);
        messageDO.setContent(projectDO.getProjectName() + ": 项目向你发出邀请！");
        messageDO.setReceivedUserId(userId);
        messageDO.setRead(false);
        messageRepo.save(messageDO);
        saveInvited(userId, projectId, inviteType);
    }

    @Override
    public List<HospitalDTO> getProjectHospitalList(Long projectId) {
        List<HospitalDTO> hospitalDTOS = new ArrayList<>();
        for (HospitalDO h : projectRepo.findOne(projectId).getHospitalList()) {
            hospitalDTOS.add(convertUtil.convertHospitalDTO(h));
        }
        return hospitalDTOS;
    }

    @Override
    public List<ProjectUsersDTO> getUsersInProject(Long projectId) {
        List<ProjectUsersDTO> projectUsersDTOS = new ArrayList<>();
        for (UserProjectRoleDO p : userProjectRoleRepo.findByProjectId(projectId)) {
            ProjectUsersDTO pro = new ProjectUsersDTO();
            pro.setProjectRoleName(
                    projectRoleRepo.findOne(p.getProjectRoleId()).getProjectRoleName());
            pro.setUserName(userRepo.findOne(p.getUserId()).getRealName());
            projectUsersDTOS.add(pro);
        }
        return projectUsersDTOS;
    }

    public void saveInvited(Long userId, Long projectId, String inviteType) {
        UserProjectRoleDO userProjectRoleDO = new UserProjectRoleDO();
        userProjectRoleDO.setProjectId(projectId);
        userProjectRoleDO
                .setProjectRoleId(projectRoleRepo.findByProjectRoleName(inviteType).getId());
        userProjectRoleDO.setUserId(userId);
        userProjectRoleDO.setAccept(false);

        ProjectDO projectDO = projectRepo.findOne(projectId);
        UserDO userDO = userRepo.findOne(userId);
        if (!projectDO.getHospitalList().isEmpty()) {
            for (HospitalDO h : projectDO.getHospitalList()) {
                if (h.getId() == userDO.getHospital().getId()) {
                    userProjectRoleRepo.save(userProjectRoleDO);
                    break;
                } else {
                    projectDO.getHospitalList().add(userDO.getHospital());
                    projectRepo.save(projectDO);
                    userProjectRoleRepo.save(userProjectRoleDO);
                    break;
                }
            }
        } else {
            projectDO.getHospitalList().add(userDO.getHospital());
            projectRepo.save(projectDO);
            userProjectRoleRepo.save(userProjectRoleDO);
        }
    }

    public void acceptInvited(Long userId, String projectName) {
        ProjectDO projectDO = projectRepo.findByProjectName(projectName);
        UserProjectRoleDO p = userProjectRoleRepo.getRoleId(userId, projectDO.getId());
        p.setAccept(true);
        userProjectRoleRepo.save(p);
    }

    public void rejectInvited(Long userId, String projectName) {
        ProjectDO projectDO = projectRepo.findByProjectName(projectName);
        UserProjectRoleDO p = userProjectRoleRepo.getRoleId(userId, projectDO.getId());
        userProjectRoleRepo.delete(p);

    }

    public List<ProjectDTO> getProjectBySearchMsg(String msg) {
        List<ProjectDTO> projectDTOS = new ArrayList<>();
        for (ProjectDO p : projectRepo.getListProjectByMsg(msg)) {
            projectDTOS.add(convertUtil.convertToProjectDTO(p));
        }
        return projectDTOS;
    }

    public List<ProjectDTO> getCurrentUserProjectList() {
        List<ProjectDTO> projectDTOS = new ArrayList<>();
        for (ProjectDO p : projectRepo.getListProject(userMsgTool.getCurrentUserId())) {
            projectDTOS.add(convertUtil.convertToProjectDTO(p));
        }
        return projectDTOS;
    }

    public void deleteMeber(Long userId, Long projectId) {
        UserProjectRoleDO userProjectRoleDO = userProjectRoleRepo.getRoleId(userId, projectId);
        userProjectRoleDO.setAccept(false);
        userProjectRoleRepo.delete(userProjectRoleDO);
        ProjectDO projectDO = projectRepo.findOne(projectId);
        projectDO.getHospitalList().remove(userRepo.findOne(userId).getHospital());
        projectRepo.save(projectDO);

    }

    public PageDTO<UserDTO> getProjectUser(Long projectId, Pageable pageable) {
        PageDTO<UserDTO> page = new PageDTO<>();
        List<UserDTO> users = new ArrayList<>();
        Page<UserDO> page1 = userRepo.getUserByProjectDTO(projectId, pageable);
        for (UserDO u : page1) {
            users.add(convertUtil.convertToUserDTO(u));
        }
        page.setContent(users);
        page.setTotalNumber(page1.getTotalPages());
        return page;
    }

    public PageDTO<UserDTO> getProjectNotInUser(Long projectId, Pageable pageable) {
        PageDTO<UserDTO> page = new PageDTO<>();
        List<UserDTO> users = new ArrayList<>();
        Page<UserDO> page1 = userRepo.getUserNotInByProjectDTO(projectId, pageable);
        for (UserDO u : page1) {
            users.add(convertUtil.convertToUserDTO(u));
        }
        page.setContent(users);
        page.setTotalNumber(page1.getTotalPages());
        return page;
    }

    @Override
    public void dataCollectChange(String isCollect, Long projectId) {
        boolean flag;
        if ("true".equals(isCollect)) {
            flag = true;
        } else {
            flag = false;
        }
        ProjectDO projectDO = projectRepo.findOne(projectId);
        projectDO.setCollect(flag);
        projectRepo.save(projectDO);
    }

    @Override
    public String getInvitedStatus(Long userId, String projectName) {
        UserProjectRoleDO userProjectRoleDO = userProjectRoleRepo.getRoleId(userId,
                projectRepo.findByProjectName(projectName).getId());
        if (userProjectRoleDO == null) {
            return "拒绝";
        } else if (!userProjectRoleDO.isAccept()) {
            return "未选择";
        } else {
            return "接受";
        }

    }


    public void deleteProject(Long projectId) {
        // UserProjectRoleDO userProjectRoleDO = userProjectRoleRepo.findOne(projectId);
        projectRepo.delete(projectId);
    }

    @Override
    public List<Integer> getProjectData(Long projectId) {
        List<Integer> projectDataList = new ArrayList<>();
        Long currentHospitalId = new UserMsgTool().getCurrentUser().getHospital().getId();
        projectDataList.add(projectRepo.getMan(projectId));
        projectDataList.add(projectRepo.getWoman(projectId));
        projectDataList.add(projectRepo.getSaveCount(projectId));
        projectDataList.add(projectRepo.getPushCount(projectId));
        projectDataList.add(projectRepo.getAllCount(projectId));
        projectDataList.add(projectRepo.getHospitalCount(projectId, currentHospitalId));
        projectDataList.add(projectRepo.getHospitalMan(projectId, currentHospitalId));
        projectDataList.add(projectRepo.getHospitalWoman(projectId, currentHospitalId));
        return projectDataList;
    }

    private ProjectDO convertToDO(ProjectDTO projectDTO) {
        ProjectDO projectDO = new ProjectDO();
        projectDO.setCollect(true);
        projectDO.setCreate_time(new Date());
        projectDO.setIntroduction(projectDTO.getIntroduction());
        projectDO.setOrganizer(new UserMsgTool().getCurrentUser().getRealName());
        projectDO.setProjectName(projectDTO.getProjectName());
        return projectDO;

    }
}

