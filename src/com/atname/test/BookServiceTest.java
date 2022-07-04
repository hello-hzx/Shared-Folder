package com.atname.test;

import com.atname.pojo.Book;
import com.atname.pojo.Page;
import com.atname.service.BookService;
import com.atname.service.impl.BookServiceImpl;
import com.atname.utils.JdbcUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Connection;

/**
 * @author 1
 * @create 09-15
 */
public class BookServiceTest {
    private BookService bookService = new BookServiceImpl();
    private Connection conn = JdbcUtils.getConnection();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null, "高等数学", "同济", new BigDecimal(20), 9191, 999, null));
//        JdbcUtils.close(conn);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(22, "高等数学 上册", "同济大学", new BigDecimal(20), 9191, 999, null));
    }

    ;

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(22);
    }

    @Test
    public void queryBookId() {
        System.out.println(bookService.queryBookId(22));
    }

    @Test
    public void queryBooks() {
        bookService.queryBooks().forEach(System.out::println);
    }

    @Test
    public void page() {
        System.out.println(bookService.page(1, Page.PAGE_SIZE));
    }

    @Test
    public void pageByPrice() {
        System.out.println(bookService.pageByPrice(1, Page.PAGE_SIZE,10,50));
    }
}