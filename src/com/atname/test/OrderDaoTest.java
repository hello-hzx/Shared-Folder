package com.atname.test;

import com.atname.dao.OrderDao;
import com.atname.dao.impl.OrderDaoImpl;
import com.atname.pojo.Order;
import com.atname.utils.JdbcUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;

/**
 * @author 1
 * @create 09-27
 */
public class OrderDaoTest {

    @Test
    public void saveOrder() {
        Connection conn = JdbcUtils.getConnection();
        OrderDao orderDao = new OrderDaoImpl();
        orderDao.saveOrder(/*conn,*/ new Order("12121212",new Date(),new BigDecimal(100),0,1));
    }
}