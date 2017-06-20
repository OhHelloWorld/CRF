package app.serviceImpl;

import app.Utils.ConvertUtil;
import app.credential.PasswordHelper;
import app.dto.UserDTO;
import app.entities.UserDO;
import app.repo.UserRepo;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public UserDTO addUser(UserDTO userDTO) {
        UserDO userDO = convertUtil.convertToUserDO(userDTO);
        passwordHelper.encrypUserPassword(userDO);
        return convertUtil.convertToUserDTO(userDO);
    }
}
