package com.atname.dao;

import com.atname.pojo.Book;

import java.util.List;

/**
 * 对Book的基本操作
 *
 * @author 1
 * @create 09-14
 */
public interface BookDao {
    /**
     * 添加图书
     *
     * @param book
     * @param conn
     * @return
     */
    int addBook(/*Connection conn,*/Book book);

    /**
     * 删除图书
     *
     * @param id
     * @param conn
     * @return
     */
    int deleteBookById(/*Connection conn,*/Integer id);

    /**
     * 更改图书
     *
     * @param book
     * @param conn
     * @return
     */
    int updateBook(/*Connection conn,*/Book book);

    /**
     * 根据id查询图书
     *
     * @param id
     * @param conn
     * @return
     */
    Book queryBookId(/*Connection conn,*/Integer id);

    /**
     * 查询所有图书
     *
     * @param conn
     * @return
     */
    List<Book> queryBooks(/*Connection conn*/);

    /**
     * 总记录数
     * @return
     */
    Integer queryForPageTotalCount(/*Connection conn*/);

    /**
     * 每页数据
     * @param begin
     * @param pageSize
     * @return
     */
    List<Book> queryForPageItems(/*Connection conn,*/int begin, int pageSize);

    /**
     * 价格区间的总记录数
     * @param conn
     * @return
     */
    Integer queryForPageTotalCountByPrice(/*Connection conn,*/int min,int max);

    /**
     * 价格区间的数据
     * @param conn
     * @param begin
     * @param pageSize
     * @param min
     * @param max
     * @return
     */
    List<Book> queryForPageItemsByPrice(/*Connection conn,*/ int begin, int pageSize, int min, int max);
}
