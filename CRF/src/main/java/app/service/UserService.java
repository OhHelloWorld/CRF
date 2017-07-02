package app.service;

import app.dto.PageDTO;
import app.dto.UserDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by 52400 on 2017/6/20.
 */
public interface UserService {

    UserDTO addUser(UserDTO userDTO);

    List<UserDTO> getUserBySearchMsg(String msg);//根据搜索的用户名，真实姓名，账号找到用户

    PageDTO<UserDTO> getAllNormalUser(Pageable pageable);//得到所有普通用户
}
