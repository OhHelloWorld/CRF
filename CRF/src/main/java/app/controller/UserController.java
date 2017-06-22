package app.controller;

import app.dto.UserDTO;
import app.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 52400 on 2017/6/20.
 */
@RestController
@RequestMapping(value = "/api/users")
@Api(value = "用户")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "")
    @ApiOperation(value = "注册用户")
    public UserDTO register(@RequestBody UserDTO userDTO) {
        return userService.addUser(userDTO);
    }
}
