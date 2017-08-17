package app.service;

import app.dto.ProjectDTO;
import app.dto.ProjectPermissionDTO;

import java.util.List;

/**
 * Created by 52400 on 2017/6/21.
 */
public interface ProjectPermissionServce {

    /**
     * 通过userid和projectid得到这个用户在这个项目里面的权限
     * @param projectId
     * @return
     */
    List<ProjectPermissionDTO> getByUserIdAndProjectId( Long projectId);
}
