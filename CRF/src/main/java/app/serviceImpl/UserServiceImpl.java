package app.serviceImpl;

import app.Exception.RepeatAccountException;
import app.Utils.ConvertUtil;
import app.credential.PasswordHelper;
import app.dto.UserDTO;
import app.entities.UserDO;
import app.repo.UserRepo;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    @Transactional
    public UserDTO addUser(UserDTO userDTO) {
        if(userRepo.findByAccount(userDTO.getAccount()) == null) {
            UserDO userDO = convertUtil.convertToUserDO(userDTO);
            passwordHelper.encrypUserPassword(userDO);
            userRepo.save(userDO);
            return convertUtil.convertToUserDTO(userDO);
        }else {
            throw new RepeatAccountException("该账号已被注册");
        }
    }
}
