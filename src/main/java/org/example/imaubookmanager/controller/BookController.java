package org.example.imaubookmanager.controller;

import org.example.imaubookmanager.pojo.Book;
import org.example.imaubookmanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@PathVariable 将 URL 中的 id 参数注入到方法的 id 参数中。
//@RequestBody 将客户端的请求体转换为 Book 对象。

@RestController  // 标记为 RESTful 控制器
@RequestMapping("/books")  // 请求路径前缀为 "/books"
public class BookController {

    @Autowired
    private BookService bookService;

    // 1. 获取所有书籍
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();  // 调用 BookService 获取所有书籍
    }

    // 2. 根据 ID 获取书籍
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        return bookService.getBookById(id);  // 根据书籍 ID 查询书籍
    }

    // 3. 添加新书籍 (ID 由数据库自动生成)
    @PostMapping
    public String createBook(@RequestBody Book book) {
        bookService.createBook(book);  // 调用服务层创建新书籍，ID 由数据库自增生成
        return "新书籍已成功创建!";
    }


    // 5. 根据 ID 删除书籍
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id) {
        bookService.deleteBookById(id);  // 根据书籍 ID 删除书籍
        return "书籍已删除!";
    }
}
