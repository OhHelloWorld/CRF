package app.service;

import app.entities.UserDO;

import java.util.Set;

/**
 * Created by 10210 on 2017/6/7.
 */
public interface LoginService {

    boolean inputCompareToDatabase(String account, String password);

    boolean login(String account, String password);

    UserDO getUserDOByAccount(String account);

    Set<String> listRole(String account);

    Set<String> listPermission(String account);


}
