package app.serviceImpl;

import app.Utils.ConvertUtil;
import app.dto.SysRoleDTO;
import app.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 52400 on 2017/6/20.
 */

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private ConvertUtil convertUtil;

    @Override
    public SysRoleDTO getRoleById(Long id) {
        return null;
    }
}
