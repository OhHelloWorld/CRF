package app.service;

import app.dto.ProjectRoleDTO;

import java.util.List;

/**
 * Created by 52400 on 2017/6/21.
 */
//对项目角色分类的操作，并非对项目中有什么角色操作
public interface ProjectRoleService {
    List<ProjectRoleDTO> getAllProjectRole();
}
