package com.atname.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * 数据库增删改查通用操作
 *
 * @author 1
 * @create 08-11
 */
public abstract class BaseDao {

    //    private QueryRunner runner = new QueryRunner();
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 使用 DbUtils进行数据库 增 删 改
     *
     * @param conn
     * @param sql
     * @param params
     * @return 影响的行数
     */
    public int update(/*Connection conn,*/ String sql, Object... args) {
//        try {
//            return runner.update(conn, sql, params);
//        } catch (SQLException e) {
//            e.printStackTrace();
//            // 抛出异常，然后面捕获
//            throw new RuntimeException(e);
//        }
        return jdbcTemplate.update(sql, args);
    }

    /**
     * 查询返回一个javaBean的sql语句
     *
     * @param type 返回的对象类型
     * @param sql  执行的sql语句
     * @param args sql对应的参数值
     * @param <T>  返回的类型的泛型
     * @return
     */
    public <T> T queryForOne(/*Connection conn, */Class<T> type, String sql, Object... args) {

//        try {
//            return runner.query(conn, sql, new BeanHandler<T>(type), args);
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
        try {
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(type), args);
        } catch (DataAccessException e) {
        }
        return null;
    }

    /**
     * 查询返回多个javaBean的sql语句
     *
     * @param type 返回的对象类型 * @param sql 执行的sql语句 * @param args sql对应的参数值 * @param <T> 返回的类型的泛型 * @return
     */
    public <T> List<T> queryForList(/*Connection conn, */Class<T> type, String sql, Object... args) {
//        try {
//            return runner.query(conn, sql, new BeanListHandler<T>(type), args);
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }

        List<T> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(type), args);
        return query;

    }

    /**
     * 执行返回一行一列的sql语句
     *
     * @param sql  执行的sql语句
     * @param args sql对应的参数值
     * @return
     */
    public Object queryForSingleValue(/*Connection conn, */String sql, Object... args) {
//        try {
//            return runner.query(conn, sql, new ScalarHandler(), args);
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
        return jdbcTemplate.queryForObject(sql, Object.class, args);
    }
}
