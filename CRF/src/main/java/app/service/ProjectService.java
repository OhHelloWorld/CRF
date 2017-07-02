package app.service;

import app.dto.HospitalDTO;
import app.dto.ProjectDTO;
import app.dto.ProjectUsersDTO;
import app.dto.UserDTO;

import java.util.List;

/**
 * Created by 52400 on 2017/6/21.
 */
public interface ProjectService {

    ProjectDTO addProject(ProjectDTO projectDTO);//添加项目

    ProjectDTO findProjectById(Long projectId);//根据项目id找到项目

    List<ProjectDTO> getProjectByUserId(Long userId);//根据用户id找到项目

    void deleteProjectById(Long id);//删除项目

    ProjectDTO updateProject(ProjectDTO projectDTO);//更新项目1

    void inviteUser(Long userId, Long projectId, Long projectRoleId);//邀请用户进项目

    List<HospitalDTO> getProjectHospitalList(Long projectId);//得到项目的医院列表

    List<ProjectUsersDTO> getUsersInProject(Long projectId);//得到一个项目下的用户

    void acceptInvited(Long userId, String projectName);//接受邀请

    void rejectInvited(Long userId, String projectName);//拒绝邀请

    List<ProjectDTO> getProjectBySearchMsg(String msg);//根据名字找到项目

    List<ProjectDTO> getCurrentUserProjectList();//得到当前用户下的项目列表

    void deleteMeber(Long userId, Long projectId);//踢出
}
