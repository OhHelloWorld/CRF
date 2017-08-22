package app.service;

import app.dto.SysPermissionDTO;

/**
 * Created by 52400 on 2017/6/20.
 */
public interface PermissionService {

    SysPermissionDTO getPermissionById(Long id);
}
