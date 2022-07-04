package com.atname.service;

import com.atname.pojo.User;

/**
 * Service层
 * @author 1
 * @create 08-24
 */
public interface UserService {
    /**
     * 注册用户
     * @param Connection
     * @param user
     */
    void registerUser(User user);

    /**
     * 登录
     * @param conn
     * @param user
     * @return
     */
    User login(User user);
    /**
     * 检查用户名是否可用
     * @param conn
     * @param username
     * @return 用户名存在，返回true,用户名可用（用户名不存在）返回false
     */
    boolean checkUsername(String username);
}
