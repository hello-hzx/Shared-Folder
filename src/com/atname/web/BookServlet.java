package com.atname.web;

import com.atname.pojo.Book;
import com.atname.pojo.Page;
import com.atname.service.BookService;
import com.atname.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 1
 * @create 09-15
 */
public class BookServlet extends BaseServlet {
    private BookService bookService = WebUtils.getBean(BookService.class);

    /**
     * 添加图书
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      添加图书后，定位到最后一页
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 0);
        pageNo += 1;
//      1，获取请求的参数==封装成为Book对象
        Book book = WebUtils.copyParamToBean(request.getParameterMap(), new Book());
//      2，调用bookService.addBook()保存图书
        bookService.addBook(book);
//      3，跳到图书列表页面
        // 请求转发有bug
//        request.getRequestDispatcher("pages/manager/bookServlet?action=list").forward(request,response);
        response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + pageNo);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求参数
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        // 调用bookService.deleteBookById()；删除图书
        bookService.deleteBookById(id);
        // 重定向回图书管理页面
        response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + request.getParameter("pageNo"));
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1，获取请求的参数==封装成为Book对象
        Book book = WebUtils.copyParamToBean(request.getParameterMap(), new Book());
//        2，调用BookService.updateBook( book);修改图书
        bookService.updateBook(book);
//        3，重定向回图书列表管理页面
//        地址:/工程名/manager/bookServlet?action=List
        response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + request.getParameter("pageNo"));

    }

    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1通过BookService查询全部图书
        List<Book> books = bookService.queryBooks();
        //2把全部图书保存到Request域中
        request.setAttribute("books", books);
        //3，请求转发到/pages/manager/book_manager.jsp页面
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
    }

    protected void getBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求参数中图书编号
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        // bookService.queryBookById()查询图书
        Book book = bookService.queryBookId(id);
        // 图书信息保存到request域中
        request.setAttribute("book", book);
        // 请求转发到 pages/manager/book_edit.jsp
        request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request, response);
    }

    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1获取请求的参数pageNo和pageSize
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        // 2调用BookService.page(pageNo，pageSize): page对象
        Page<Book> page = bookService.page(pageNo, pageSize);
        // 设置请求地址
        page.setUrl("manager/bookServlet?action=page");

        // 3保存Page对象到Request域中
        request.setAttribute("page", page);
        // 4请求转发到pages/manager/book_manager.jsp页面
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
    }
}
