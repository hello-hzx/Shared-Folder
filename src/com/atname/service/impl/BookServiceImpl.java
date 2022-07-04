package com.atname.service.impl;

import com.atname.dao.BookDao;
import com.atname.pojo.Book;
import com.atname.pojo.Page;
import com.atname.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 1
 * @create 09-14
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public void addBook(Book book) {
//        Connection conn = JdbcUtils.getConnection();
        bookDao.addBook(/*conn,*/ book);

    }

    @Override
    public void deleteBookById(Integer id) {
//        Connection conn = JdbcUtils.getConnection();
        bookDao.deleteBookById(/*conn,*/ id);

    }

    @Override
    public void updateBook(Book book) {
//        Connection conn = JdbcUtils.getConnection();
        bookDao.updateBook(/*conn,*/ book);

    }

    @Override
    public Book queryBookId(Integer id) {
//        Connection conn = JdbcUtils.getConnection();
        Book book = bookDao.queryBookId(/*conn,*/ id);

        return book;

    }

    @Override
    public List<Book> queryBooks() {
//        Connection conn = JdbcUtils.getConnection();
        List<Book> books = bookDao.queryBooks(/*conn*/);
        return books;
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
//        Connection conn = JdbcUtils.getConnection();
        Page<Book> page = new Page<>();
        // 每页显示数量
        page.setPageSize(pageSize);
        // 总记录数
        Integer pageTotalCount = bookDao.queryForPageTotalCount(/*conn*/);
        page.setPageTotalCount(pageTotalCount);
        // 求总页码
        int pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal += 1;
        }
        page.setPageTotal(pageTotal);
        // 当前页码
        page.setPageNo(pageNo);
        // 当前页数据
        //      begin求当页开始索引
        int begin = (page.getPageNo() - 1) * pageSize;
        List<Book> items = bookDao.queryForPageItems(/*conn,*/begin, pageSize);
        page.setItems(items);

        return page;
    }

    /**
     * 价格查询区间分页
     *
     * @param pageNo
     * @param pageSize
     * @param min
     * @param max
     * @return
     */
    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
//        Connection conn = JdbcUtils.getConnection();
        Page<Book> page = new Page<>();
        // 每页显示数量
        page.setPageSize(pageSize);
        // 价格区间的总记录数
        Integer pageTotalCount = bookDao.queryForPageTotalCountByPrice(/*conn,*/min, max);
        page.setPageTotalCount(pageTotalCount);
        // 求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal += 1;
        }
        page.setPageTotal(pageTotal);
        // 当前页码
        page.setPageNo(pageNo);
        // 当前页数据
        //      begin求当页开始索引
        int begin = (page.getPageNo() - 1) * pageSize;
        List<Book> items = bookDao.queryForPageItemsByPrice(/*conn,*/begin, pageSize, min, max);
        page.setItems(items);

        return page;
    }

}
