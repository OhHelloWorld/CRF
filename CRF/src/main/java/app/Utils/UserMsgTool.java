package app.Utils;

import app.dto.UserDTO;
import app.entities.UserDO;
import app.repo.UserRepo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * Created by 52400 on 2017/6/21.
 */
@Service
public class UserMsgTool {

    @Autowired
    private UserRepo userRepo;

    //得到当前用户
    public UserDO getCurrentUser() {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        return (UserDO) session.getAttribute("user");
    }

    //得到当前用户的用户名
    public String getCurrentUserAccount() {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        UserDO userDO = (UserDO) session.getAttribute("user");
        return userDO.getAccount();
    }

    //得到当前用户的id
    public Long getCurrentUserId() {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        UserDO userDO = (UserDO) session.getAttribute("user");
        return userDO.getId();
    }

}
