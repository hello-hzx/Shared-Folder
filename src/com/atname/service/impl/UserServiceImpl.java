package com.atname.service.impl;

import com.atname.dao.UserDao;
import com.atname.pojo.User;
import com.atname.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author 1
 * @create 08-24
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public void registerUser(User user) {
//        Connection conn = JdbcUtils.getConnection();
        userDao.saveUser(/*conn,*/ user);
    }

    @Override
    public User login(User user) {
//        Connection conn = JdbcUtils.getConnection();
        return userDao.queryUserByUsernameAndPassword(/*conn, */user.getUsername(), user.getPassword());
    }

    @Override
    public boolean checkUsername(String username) {
//        Connection conn = JdbcUtils.getConnection();
        if (userDao.queryUserByUsername(/*conn, */username) == null) {
            //没查到用户，及用户名可用
            return false;
        }
        return true;
    }
}
