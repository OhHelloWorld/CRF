package app.service;

import app.dto.UserDTO;
import app.entities.UserDO;

/**
 * Created by 52400 on 2017/6/20.
 */
public interface UserService {

    UserDTO addUser(UserDTO userDTO);
}
