package app.serviceImpl;

import app.Utils.ConvertUtil;
import app.dto.UserDTO;
import app.entities.SysPermissionDO;
import app.entities.UserDO;
import app.repo.LoginRepo;
import app.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by 10210 on 2017/6/7.
 */
@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private LoginRepo loginRepo;

    @Autowired
    private ConvertUtil convertUtil;


    @Override
    public boolean inputCompareToDatabase(String account, String password) {
        List<UserDO> user = loginRepo.inputCompareToDatabase(account, password);
        if(user.size() == 0){
            return false;
        }
        return true;
    }

    @Override
    public UserDO getUserDOByAccount(String account) {
        return loginRepo.findByAccount(account);
    }

    @Override
    public Set<String> listRole(String account) {
        UserDO userDO = loginRepo.findByAccount(account);
        Set<String> roles = new HashSet<>();
        roles.add(userDO.getSysRoleDO().getSysRoleName());
        return roles;
    }

    @Override
    public Set<String> listPermission(String account) {
        UserDO userDO = loginRepo.findByAccount(account);
        Set<String> permissions = new HashSet<>();
        for(SysPermissionDO p : userDO.getSysRoleDO().getListPermission()) {
            permissions.add(p.getSysPermissionName());
        }
        return permissions;
    }

    @Override
    public UserDTO getUserDTOByAccount(String account) {
        return convertUtil.convertToUserDTO(loginRepo.findByAccount(account));
    }
}
