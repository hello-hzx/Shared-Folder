package com.atname.dao.impl;

import com.atname.dao.OrderItemDao;
import com.atname.pojo.OrderItem;
import org.springframework.stereotype.Repository;

/**
 * @author 1
 * @create 09-27
 */
@Repository
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(/*Connection conn,*/ OrderItem orderItem) {
        String sql = "insert into t_order_Item(`name`,`count`,`price`,`total_price`,`order_id`) values(?,?,?,?,?)";
        return update(/*conn,*/sql,orderItem.getName(),orderItem.getCount(),orderItem.getTotalPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());
    }
}