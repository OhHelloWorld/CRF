package app.service;

import app.dto.UserDTO;

import java.util.List;

/**
 * Created by 52400 on 2017/6/20.
 */
public interface UserService {

    UserDTO addUser(UserDTO userDTO);

    List<UserDTO> getUserBySearchMsg(String msg);//根据搜索的用户名，真实姓名，账号找到用户
}
