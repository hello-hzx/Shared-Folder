package com.atname.test;

import com.atname.pojo.Cart;
import com.atname.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author 1
 * @create 09-24
 */
public class CartTest {

    @Test
    public void addItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "java", 1, new BigDecimal(90), new BigDecimal(90)));
        cart.addItem(new CartItem(1, "java", 1, new BigDecimal(90), new BigDecimal(90)));
        cart.addItem(new CartItem(2, "C++", 1, new BigDecimal(20), new BigDecimal(20)));
        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "java", 1, new BigDecimal(90), new BigDecimal(90)));
        cart.addItem(new CartItem(1, "java", 1, new BigDecimal(90), new BigDecimal(90)));
        cart.addItem(new CartItem(2, "C++", 1, new BigDecimal(20), new BigDecimal(20)));
        cart.deleteItem(1);
        System.out.println(cart);
    }

    @Test
    public void clear() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "java入门", 1, new BigDecimal(90), new BigDecimal(90)));
        cart.addItem(new CartItem(1, "java入门", 1, new BigDecimal(90), new BigDecimal(90)));
        cart.addItem(new CartItem(2, "C++入门", 1, new BigDecimal(20), new BigDecimal(20)));
        cart.clear();
        System.out.println(cart);
        cart.addItem(new CartItem(1, "java入门", 1, new BigDecimal(90), new BigDecimal(90)));
        cart.updateCount(1,4);
        System.out.println(cart);
    }

    @Test
    public void updateCount() {
    }
}