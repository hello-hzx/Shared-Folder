package com.atname.web;

import com.atname.pojo.Cart;
import com.atname.pojo.User;
import com.atname.service.OrderService;
import com.atname.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 1
 * @create 09-28
 */
public class OrderServlet extends BaseServlet {
    private OrderService orderService = WebUtils.getBean(OrderService.class);

    /**
     * 生成订单
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        // 获取用户id
        User user = (User) req.getSession().getAttribute("user");
        //      判断用户登录？
        if (user == null) {
            // 转到登录页面
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return;
        }
        Integer id = user.getId();
        // 调取orderService.createOrder(Cart,UserId)生成订单，返回订单号
        String orderId = orderService.createOrder(cart, id);

        // 订单号存到Session域中
        req.getSession().setAttribute("orderId",orderId);
        // 请求转发到
        // req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req,resp);

        // 重定向（防止重复提交）
        resp.sendRedirect(req.getContextPath() + "/pages/cart/checkout.jsp");
    }
}
