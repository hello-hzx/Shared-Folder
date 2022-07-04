package com.atname.service;

import com.atname.pojo.Book;
import com.atname.pojo.Page;

import java.util.List;

/**
 * @author 1
 * @create 09-14
 */
public interface BookService {
    /**
     * 添加图书
     *
     * @param book
     */
    void addBook(Book book);

    /**
     * 删除图书
     *
     * @param id
     */
    void deleteBookById(Integer id);

    /**
     * 更改图书
     *
     * @param book
     */

    void updateBook(Book book);

    /**
     * 根据id查询图书
     *
     * @param id
     * @return
     */
    Book queryBookId(Integer id);

    /**
     * 查询所有图书
     *
     * @return
     */
    List<Book> queryBooks();

    /**
     * 分页
     * @param pageNo
     * @param pageSize
     * @return
     */
    Page<Book> page(int pageNo,int pageSize);

    Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);
}
