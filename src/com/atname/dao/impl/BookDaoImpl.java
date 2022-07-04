package com.atname.dao.impl;

import com.atname.dao.BookDao;
import com.atname.pojo.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 1
 * @create 09-14
 */
@Repository
public class BookDaoImpl extends BaseDao implements BookDao {


    @Override
    public int addBook(/*Connection conn, */Book book) {
        String sql = "insert into t_book(`name`,`author`,`price`,`sales`,`stock`,`img_path`) values(?,?,?,?,?,?)";
        return update(/*conn, */sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath());
    }

    @Override
    public int deleteBookById(/*Connection conn, */Integer id) {
        String sql = "delete from t_book where `id`=?";
        return update(/*conn, */sql, id);
    }

    @Override
    public int updateBook(/*Connection conn,*/ Book book) {
        String sql = "update t_book set `name`=?,`author`=?,`price`=?,`sales`=?,`stock`=?,`img_path`=? where id = ?";
        return update(/*conn,*/ sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath(), book.getId());
    }

    @Override
    public Book queryBookId(/*Connection conn, */Integer id) {
        String sql = "select `id`,`name`,`author`,`price`,`sales`,`stock`,`img_path` imgPath from t_book where id = ?";
        return queryForOne(/*conn,*/ Book.class, sql, id);
    }

    @Override
    public List<Book> queryBooks(/*Connection conn*/) {
        String sql = "select `id`,`name`,`author`,`price`,`sales`,`stock`,`img_path` imgPath from t_book";
        return queryForList(/*conn,*/ Book.class, sql);
    }

    @Override
    public Integer queryForPageTotalCount(/*Connection conn*/) {
        String sql = "select count(*) from t_book";
        Number count = (Number) queryForSingleValue(/*conn, */sql);
        return count.intValue();
    }

    @Override
    public List<Book> queryForPageItems(/*Connection conn, */int begin, int pageSize) {
        String sql = "select `id`,`name`,`author`,`price`,`sales`,`stock`,`img_path` imgPath from t_book limit ?,?";
        return queryForList(/*conn, */Book.class, sql, begin, pageSize);
    }

    @Override
    public Integer queryForPageTotalCountByPrice(/*Connection conn, */int min, int max) {
        String sql = "select count(*) from t_book where price between ? and ?";
        Number count = (Number) queryForSingleValue(/*conn, */sql, min, max);
        return count.intValue();
    }

    @Override
    public List<Book> queryForPageItemsByPrice(/*Connection conn,*/ int begin, int pageSize, int min, int max) {
        String sql = "select `id`,`name`,`author`,`price`,`sales`,`stock`,`img_path` imgPath from t_book where price between ? and ? order by price limit ?,?";
        return queryForList(/*conn,*/ Book.class, sql, min, max, begin, pageSize);
    }
}
