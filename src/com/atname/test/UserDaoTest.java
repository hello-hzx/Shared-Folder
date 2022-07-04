package com.atname.test;

import com.atname.dao.UserDao;
import com.atname.dao.impl.UserDaoImpl;
import com.atname.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

/**
 * @author 1
 * @create 08-24
 */
public class UserDaoTest {
    UserDao userDao = new UserDaoImpl();
    Connection conn = JdbcUtils.getConnection();

    @Test
    public void queryUserByUsername() {

        if(userDao.queryUserByUsername(/*conn,*/"admin")==null) {
            System.out.println("用户名可用");
        } else {
            System.out.println("用户名已存在");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
    }

    @Test
    public void saveUser() {
    }
}