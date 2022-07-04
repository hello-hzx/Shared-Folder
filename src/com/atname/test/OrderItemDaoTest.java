package com.atname.test;

import com.atname.dao.OrderItemDao;
import com.atname.dao.impl.OrderItemDaoImpl;
import com.atname.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author 1
 * @create 09-27
 */
public class OrderItemDaoTest {

    @Test
    public void saveOrderItem() {
//        Connection conn = JdbcUtils.getConnection();
        OrderItemDao orderItemDao = new OrderItemDaoImpl();
        orderItemDao.saveOrderItem(/*conn, */new OrderItem(null,"数据结构",1,new BigDecimal(2121),new BigDecimal(2121),"12121212"));
    }
}