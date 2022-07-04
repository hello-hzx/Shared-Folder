package com.atname.test;

import com.atname.dao.BookDao;
import com.atname.dao.impl.BookDaoImpl;
import com.atname.pojo.Book;
import com.atname.utils.JdbcUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Connection;

/**
 * @author 1
 * @create 09-14
 */
public class BookDaoTest {
    private BookDao bookDao = new BookDaoImpl();
    private Connection conn = JdbcUtils.getConnection();


    @Test
    public void addBook() {
        bookDao.addBook(/*conn, */new Book(null, "web前端", "婉君", new BigDecimal(666), 10001, 0, null));
    }

    @Test
    public void deleteBookById() {
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(/*conn, */new Book(21, "web前端设计", "婉君", new BigDecimal(666), 10001, 1, null));
    }

    @Test
    public void queryBookId() {
        System.out.println(bookDao.queryBookId(/*conn,*/ 21));
    }

    @Test
    public void queryBooks() {
        for (Book queryBook : bookDao.queryBooks(/*conn*/)) {
            System.out.println(queryBook);
        }
    }

    @Test
    public void queryForPageTotalCount() {
        System.out.println(bookDao.queryForPageTotalCount(/*conn*/));
    }

    @Test
    public void queryForPageItems() {
        bookDao.queryForPageItems(/*conn,*/ 8, 4).forEach(System.out::println);
    }

    @Test
    public void queryForPageTotalCountByPrice() {
        System.out.println(bookDao.queryForPageTotalCountByPrice(/*conn,*/10,50));
    }

    @Test
    public void queryForPageItemsByPrice() {
        bookDao.queryForPageItemsByPrice(/*conn,*/0,4, 10, 50).forEach(System.out::println);
    }


}