package com.atname.service;

import com.atname.pojo.Cart;

/**
 * @author 1
 * @create 09-27
 */
public interface OrderService {
    /**
     * 创建订单
     * @param cart
     * @param userId
     * @return
     */
    String createOrder(Cart cart,Integer userId);
}
