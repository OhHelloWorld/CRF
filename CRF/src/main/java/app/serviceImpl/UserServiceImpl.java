package app.serviceImpl;

import app.Exception.RepeatAccountException;
import app.Utils.ConvertUtil;
import app.credential.PasswordHelper;
import app.dto.PageDTO;
import app.dto.UserDTO;
import app.entities.UserDO;
import app.repo.HospitalRepo;
import app.repo.SysRoleRepo;
import app.repo.UserRepo;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
        userDO.setHospital(hospitalRepo.findOne(userDTO.getHospital().getId()));
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

    public PageDTO<UserDTO> getAllNormalUser(Pageable pageable) {
        return getPageDTO(userRepo.getAllNormalUser(pageable));
    }

    @Override
    public UserDO getUserDOByAccount(String account) {
        return userRepo.findByAccount(account);
    }

    public PageDTO<UserDTO> getPageDTO(Page<UserDO> page) {
        PageDTO<UserDTO> pageDTO = new PageDTO<>();
        List<UserDTO> caseDTOList = new ArrayList<>();
        for(UserDO c : page.getContent()) {
            caseDTOList.add(convertUtil.convertToUserDTO(c));
        }
        pageDTO.setTotalNumber(page.getTotalPages());
        pageDTO.setContent(caseDTOList);
        return  pageDTO;
    }

    public PageDTO<UserDTO> getUserByRealName(String realName, Long projectId, Pageable pageable) {
        return getPageDTO(userRepo.getByRealName(realName, projectId, pageable));
    }

}
