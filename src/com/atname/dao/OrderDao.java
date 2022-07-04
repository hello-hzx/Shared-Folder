package com.atname.dao;

import com.atname.pojo.Order;

/**
 * @author 1
 * @create 09-27
 */
public interface OrderDao {
    /**
     * 保存订单
     *
     * @param order
     * @param conn
     * @return
     */
    int saveOrder(/*Connection conn, */Order order);
}
