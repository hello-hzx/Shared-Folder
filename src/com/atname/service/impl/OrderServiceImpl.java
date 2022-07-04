package com.atname.service.impl;

import com.atname.dao.BookDao;
import com.atname.dao.OrderDao;
import com.atname.dao.OrderItemDao;
import com.atname.pojo.*;
import com.atname.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * @author 1
 * @create 09-27
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private OrderItemDao orderItemDao;
    @Autowired
    private BookDao bookDao;


    @Override
    public String createOrder(Cart cart, Integer userId) {
//        Connection conn = JdbcUtils.getConnection();
        // 唯一的订单号
        String orderId = System.currentTimeMillis() + "" + userId;
        // 创建订单对象
        Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId);
        //  保存订单
        orderDao.saveOrder(/*conn,*/ order);

//        int i = 1/0;
        // 将商品信息转为订单项存入数据库
        for (Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()) {
            // 获取购物车中的商品项
            CartItem cartItem = entry.getValue();
            // 转为订单项
            OrderItem orderItem = new OrderItem(null, cartItem.getName(), cartItem.getCount(), cartItem.getPrice(), cartItem.getTotalPrice(), orderId);
            // 保存订单项到数据库
            orderItemDao.saveOrderItem(/*conn, */orderItem);

            // 售出商品后更新库存，销量
            Book book = bookDao.queryBookId(/*conn, */cartItem.getId());
            book.setSales(book.getSales() + cartItem.getCount());
            book.setStock(book.getStock() - cartItem.getCount());
            bookDao.updateBook(/*conn,*/book);
        }
        // 清空购物车
        cart.clear();
        return orderId;
    }
}
