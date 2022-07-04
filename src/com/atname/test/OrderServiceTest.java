package com.atname.test;

import com.atname.pojo.Cart;
import com.atname.pojo.CartItem;
import com.atname.service.OrderService;
import com.atname.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;


/**
 * @author 1
 * @create 09-27
 */
public class OrderServiceTest {

    @Test
    public void createOrder() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "java", 1, new BigDecimal(90), new BigDecimal(90)));
        cart.addItem(new CartItem(1, "java", 1, new BigDecimal(90), new BigDecimal(90)));
        cart.addItem(new CartItem(2, "C++", 1, new BigDecimal(20), new BigDecimal(20)));

        OrderService orderService = new OrderServiceImpl();
        System.out.println(orderService.createOrder(cart,1));
    }
}