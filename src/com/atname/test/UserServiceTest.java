package com.atname.test;

import com.atname.pojo.User;
import com.atname.service.UserService;
import com.atname.service.impl.UserServiceImpl;
import org.junit.Test;

/**
 * @author 1
 * @create 08-24
 */
public class UserServiceTest {
    UserService userService = new UserServiceImpl();

    @Test
    public void registerUser() {
        userService.registerUser(new User( null,"qq", "qq123", "qq@qq.com"));
    }

    @Test
    public void login() {
        User user = userService.login(new User(null, "qq", "qq123", null));
        System.out.println(user);

    }

    @Test
    public void checkUsername() {
        if (userService.checkUsername("qq")) {
            System.out.println("用户名存在");
        } else {
            System.out.println("用户名可用");
        }
    }


}