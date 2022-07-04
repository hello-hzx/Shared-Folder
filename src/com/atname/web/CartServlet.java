package com.atname.web;

import com.atname.pojo.Book;
import com.atname.pojo.Cart;
import com.atname.pojo.CartItem;
import com.atname.service.BookService;
import com.atname.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 1
 * @create 09-25
 */
public class CartServlet extends BaseServlet {
    private BookService bookService = WebUtils.getBean(BookService.class);

    /**
     * 修改商品数量
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取商品数量与修改值
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        int count = WebUtils.parseInt(req.getParameter("count"), 1);
        // 获取购物车
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        // 修改商品数量
        cart.updateCount(id, count);
        // 重定向会原页面
        resp.sendRedirect(req.getHeader("Referer"));
    }

    /**
     * 清空购物车
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        // 清空
        cart.clear();
        // 重定向会原页面
        resp.sendRedirect(req.getHeader("Referer"));
    }

    /**
     * 删除商品项
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取商品编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        // 获取购物测对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        // 删除
        cart.deleteItem(id);
        // 重定向会原来页面
        resp.sendRedirect(req.getHeader("Referer"));
    }

    /**
     * 加入购物车
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求参数 商品编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        // 通过bookService.queryById(id):得到图书
        Book book = bookService.queryBookId(id);
        // 将图书转为商品项
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        // 调用Cart.addItem(CartItem)添加商品项
        //      获取session域中得Cart对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        //      session域中无cart对象，
        if (cart == null) {
            cart = new Cart();
            // 将cart存入session域
            req.getSession().setAttribute("cart", cart);
        }
        cart.addItem(cartItem);

        // 最后添加的商品name存入session域到前台显示
        req.getSession().setAttribute("lastName",cartItem.getName());
        // 重定向会原来的商品页面
        //      在HTTP协议中有一个请求头 Referer，可以把请求发起时浏览器地址栏中的地址发送给服务器
        resp.sendRedirect(req.getHeader("Referer"));
    }

}
