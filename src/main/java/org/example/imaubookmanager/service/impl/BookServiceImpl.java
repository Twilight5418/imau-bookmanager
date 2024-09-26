package org.example.imaubookmanager.service.impl;

// 引入所需的类和接口
import org.example.imaubookmanager.dao.BookDao;
import org.example.imaubookmanager.pojo.Book;    // Book实体类，映射数据库的书籍表
import org.example.imaubookmanager.service.BookService;  // BookService接口，定义业务层的操作
import org.springframework.beans.factory.annotation.Autowired;  // 用于依赖注入
import org.springframework.stereotype.Service;  // 用于将该类标记为Spring的服务类，便于Spring管理

import java.util.List;  // 引入List类，用于返回书籍列表

/**
 * BookServiceImpl 实现了 BookService 接口，封装了对书籍表的业务逻辑操作
 * 通过调用 BookDao 进行数据库操作
 */
@Service  // 标记为Service层的实现类，Spring会自动管理该类
public class BookServiceImpl implements BookService {  // 实现 BookService 接口

    @Autowired  // 使用Spring的依赖注入，将BookDao自动注入到该类中
    private BookDao bookDao;  // DAO层对象，用于与数据库交互

    /**
     * 根据书籍ID查询书籍信息
     * @param id 书籍ID
     * @return 返回查询到的书籍对象
     */
    @Override
    public Book getBookById(int id) {
        return bookDao.selectBookById(id);  // 调用 DAO 层的 selectBookById 方法，返回对应ID的书籍
    }

    /**
     * 查询所有书籍信息
     * @return 返回所有书籍的列表
     */
    @Override
    public List<Book> getAllBooks() {
        return bookDao.selectAllBooks();  // 调用 DAO 层的 selectAllBooks 方法，返回所有书籍信息
    }

    /**
     * 创建新书籍
     * @param book 需要创建的书籍对象
     * @return 返回受影响的行数（通常为1，如果插入成功）
     */
    @Override
    public int createBook(Book book) {
        return bookDao.insertBook(book);  // 调用 DAO 层的 insertBook 方法，将新书籍信息插入数据库
    }

    /**
     * 更新书籍信息
     * @param book 需要更新的书籍对象
     * @return 返回受影响的行数（通常为1，如果更新成功）
     */
    @Override
    public int updateBook(Book book) {
        return bookDao.updateBook(book);  // 调用 DAO 层的 updateBook 方法，更新书籍信息
    }

    /**
     * 根据书籍ID删除书籍
     * @param id 书籍ID
     * @return 返回受影响的行数（通常为1，如果删除成功）
     */
    @Override
    public int deleteBookById(int id) {
        return bookDao.deleteBookById(id);  // 调用 DAO 层的 deleteBookById 方法，根据ID删除书籍
    }
}
