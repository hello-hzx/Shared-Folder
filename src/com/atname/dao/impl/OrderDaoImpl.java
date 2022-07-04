package com.atname.dao.impl;

import com.atname.dao.OrderDao;
import com.atname.pojo.Order;
import org.springframework.stereotype.Repository;

/**
 * @author 1
 * @create 09-27
 */
@Repository
public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(/*Connection conn,*/Order order) {
        String sql = "insert into t_order(`order_id`,`create_time`,`price`,`status`,`user_id`) values(?,?,?,?,?)";
        return update(/*conn,*/sql,order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());
    }
}
