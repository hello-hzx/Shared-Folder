package com.atname.dao.impl;

import com.atname.dao.UserDao;
import com.atname.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * @author 1
 * @create 08-24
 */
@Repository
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserByUsername(/*Connection conn,*/String username) {
        String sql = "select `id`,`username`,`password`,`email` from t_user where username=?";
        return queryForOne(/*conn,*/User.class,sql,username);
    }

    @Override
    public User queryUserByUsernameAndPassword(/*Connection conn,*/String username, String password) {
        String sql = "select id,username,password,email from t_user where username=? and password=?;";
        return queryForOne(/*conn,*/User.class,sql,username,password);
    }

    @Override
    public int saveUser(/*Connection conn,*/User user) {
        String sql = "insert into t_user(`username`,`password`,`email`)values(?,?,?)";

        return update(/*conn,*/sql,user.getUsername(),user.getPassword(),user.getEmail());
    }
}
