package com.atname.dao;

import com.atname.pojo.OrderItem;

/**
 * @author 1
 * @create 09-27
 */
public interface OrderItemDao {
    /**
     * 保存订单项
     * @param conn
     * @param orderItem
     * @return
     */
    int saveOrderItem(/*Connection conn,*/ OrderItem orderItem);
}
