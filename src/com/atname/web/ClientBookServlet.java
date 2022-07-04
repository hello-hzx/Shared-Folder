package com.atname.web;

import com.atname.pojo.Book;
import com.atname.pojo.Page;
import com.atname.service.BookService;
import com.atname.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 1
 * @create 09-21
 */
public class ClientBookServlet extends BaseServlet {
    BookService bookService = WebUtils.getBean(BookService.class);

    /**
     * 分页条
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1获取请求的参数pageNo和pageSize
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        // 2调用BookService.page(pageNo，pageSize): page对象
        Page<Book> page = bookService.page(pageNo, pageSize);
        // 设置请求地址
        page.setUrl("client/bookServlet?action=page");

        // 3保存Page对象到Request域中
        request.setAttribute("page", page);
        // 4请求转发到pages/manager/book_manager.jsp页面
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request, response);
    }

    /**
     * 查询价格区间
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void pageByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1获取请求的参数pageNo和pageSize,min,max
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        int min = WebUtils.parseInt(request.getParameter("min"),0);
        int max = WebUtils.parseInt(request.getParameter("max"),Integer.MAX_VALUE);
        // 2调用BookService.page(pageNo，pageSize): page对象
        Page<Book> page = bookService.pageByPrice(pageNo, pageSize,min,max);
        // 设置请求地址
        StringBuilder sb = new StringBuilder("client/bookServlet?action=pageByPrice");
        //如果有最小价格的参数,追加到分页条的地址参数中
        if (request.getParameter(  "min") != null) {
            sb.append( "&min=").append(request.getParameter("min"));
        }
        //如果有最大价格的参数,追加到分页条的地址参数中
        if (request.getParameter("max") != null) {
            sb.append( "&max=").append(request.getParameter("max"));
        }
        page.setUrl(sb.toString());
        // 3保存Page对象到Request域中
        request.setAttribute("page", page);
        // 4请求转发到pages/manager/book_manager.jsp页面
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request, response);
    }
}
 