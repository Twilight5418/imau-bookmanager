package org.example.imaubookmanager.dao;

import org.apache.ibatis.annotations.Mapper;
import org.example.imaubookmanager.pojo.Book;
import java.util.List;

@Mapper
public interface BookDao {

    // 根据 ID 查询书籍
    Book selectBookById(int bookId);

    // 查询所有书籍
    List<Book> selectAllBooks();

    // 插入新书籍
    int insertBook(Book book);

    // 更新书籍信息
    int updateBook(Book book);

    // 根据 ID 删除书籍
    int deleteBookById(int bookId);
}
