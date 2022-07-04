package com.atname.dao;

import com.atname.pojo.User;

/**
 * User的基本操作
 * @author 1
 * @create 08-24
 */
public interface UserDao {

    /**
     * 根据用户名查询用户
     * @param conn
     * @param username 用户名
     * @return 用户，不存在返回
     */
     User queryUserByUsername(/*Connection conn,*/ String username);

    /**
     * 登录操作，验证用户名与密码
     * @param conn
     * @param username
     * @param password
     * @return
     */
    User queryUserByUsernameAndPassword(/*Connection conn,*/String username,String password);

    /**
     * 保存用户信息
     * @param conn
     * @param user
     * @return
     */
     int saveUser(/*Connection conn,*/User user);
}
