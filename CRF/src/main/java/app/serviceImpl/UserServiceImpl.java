package app.serviceImpl;

import app.Exception.RepeatAccountException;
import app.Utils.ConvertUtil;
import app.credential.PasswordHelper;
import app.dto.UserDTO;
import app.entities.SysRoleDO;
import app.entities.UserDO;
import app.repo.HospitalRepo;
import app.repo.SysRoleRepo;
import app.repo.UserRepo;
import app.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 52400 on 2017/6/20.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ConvertUtil convertUtil;

    @Autowired
    private PasswordHelper passwordHelper;

    @Autowired
    private HospitalRepo hospitalRepo;

    @Autowired
    private SysRoleRepo sysRoleRepo;

    @Override
    @Transactional
    public UserDTO addUser(UserDTO userDTO) {
        UserDO userDO = convertUtil.convertToUserDO(userDTO);
        passwordHelper.encrypUserPassword(userDO);
        userDO.setHospital(hospitalRepo.findOne(userDTO.getHospitalId()));
        if(userRepo.findByAccount(userDTO.getAccount()) == null) {
            userDO.setSysRoleDO(sysRoleRepo.findOne(1L));
            userRepo.save(userDO);
            return convertUtil.convertToUserDTO(userDO);
        }else {
            throw new RepeatAccountException("该账号已被注册");
        }

    }

    @Override
    public List<UserDTO> getUserBySearchMsg(String msg) {
        List<UserDTO> userDTOList = new ArrayList<>();
        for(UserDO u : userRepo.findUserBySearchMsg(msg)) {
            userDTOList.add(convertUtil.convertToUserDTO(u));
        }
        return userDTOList;
    }
}
