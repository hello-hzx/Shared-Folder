package com.atname.pojo;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 购物车对象
 *
 * @author 1
 * @create 09-24
 */
public class Cart {
//    private Integer totalCount;
//    private BigDecimal totalPrice;

    // key是商品编号，val是商品信息
    private Map<Integer, CartItem> items = new LinkedHashMap<>();

    /**
     * 添加商品项
     *
     * @param cartItem
     */
    public void addItem(CartItem cartItem) {
        CartItem item = items.get(cartItem.getId());
        if (item == null) {
            // 未添加过此商品
            items.put(cartItem.getId(), cartItem);
        } else {
            // 已添加此商品
            item.setCount(item.getCount() + 1);
            // multiply​(BigDecimal bd)返回 BigDecimal，其值是 (this × bd).
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
        }
    }

    /**
     * 删除商品项
     *
     * @param id
     */
    public void deleteItem(Integer id) {
        items.remove(id);
    }

    /**
     * 清空购物车
     */
    public void clear() {
        items.clear();
    }

    /**
     * 更改商品数量
     *
     * @param id
     * @param count
     */
    public void updateCount(Integer id, Integer count) {
        CartItem cartItem = items.get(id);
        cartItem.setCount(count);
        cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())));
    }

    public Cart() {
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }

    public Integer getTotalCount() {
        Integer totalCount = 0;
        for (Map.Entry<Integer, CartItem> entry : items.entrySet()) {
            totalCount += entry.getValue().getCount();
        }
        return totalCount;
    }


    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (CartItem value : items.values()) {
            totalPrice = totalPrice.add(value.getTotalPrice());
        }
        return totalPrice;
    }


    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }
}
