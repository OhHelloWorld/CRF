package app.controller;

import app.dto.PageDTO;
import app.dto.UserDTO;
import app.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping(value = "")
    @ApiOperation(value = "得到所有普通用户")
    public PageDTO<UserDTO> register(@PageableDefault(value = 15) Pageable pageable) {
        return userService.getAllNormalUser(pageable);
    }

    @GetMapping(value = "/userName/{name}/{projectId}")
    @ApiOperation(value = "根据真实姓名查询")
    public PageDTO<UserDTO> getByUserByRealName(@RequestParam String name, @PageableDefault(value = 15) Pageable pageable, @PathVariable Long projectId) {
        return userService.getUserByRealName(name, projectId, pageable);
    }


}
