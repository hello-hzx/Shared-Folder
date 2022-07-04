package com.atname.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author 1
 * @create 2020-08-11 22:43
 */
@Deprecated
public class JdbcUtils {

    private static DruidDataSource dataSource;
    private static ThreadLocal<Connection> conns = new ThreadLocal<>();

    static {
        try {
            // 读取jdbc.properties属性配置文件
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbcOldm.properties");
            // 从流中加载数据
            Properties properties = new Properties();
            properties.load(inputStream);
            // 创建数据库连接池
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     *
     * @return
     */
    public static Connection getConnection() {
        Connection conn = conns.get();
        if (conn == null) {
            try {
                // 数据库连接池中取连接
                conn = dataSource.getConnection();
                // 给后面的使用
                conns.set(conn);
                // 设置为手动管理事务
                conn.setAutoCommit(false);

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return conn;
    }


    /**
     * 提交事务，关闭连接
     */
    public static void commitAndClose() {
        Connection conn = conns.get();
        if (conn != null) {
            try {
                // 提交事务
                conn.commit();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    // 释放连接
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        // 执行remove(),tomcat使用了线程池技术
        conns.remove();
    }

    /**
     * 回滚事务，关闭连接
     */
    public static void rollbackAndClose() {
        Connection conn = conns.get();
        if (conn != null) {
            try {
                // 回滚事务
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    // 释放连接
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        // 执行remove(),tomcat使用了线程池技术
        conns.remove();
    }


    /**
     * 关闭连接
     *
     * @param conn
     */
//    public static void close(Connection conn) {
//        DbUtils.closeQuietly(conn);
//
//    }
}
