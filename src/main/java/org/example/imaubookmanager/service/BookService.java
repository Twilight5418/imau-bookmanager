package org.example.imaubookmanager.service;

import org.example.imaubookmanager.pojo.Book;
import java.util.List;

public interface BookService {
    Book getBookById(int id);
    List<Book> getAllBooks();
    int createBook(Book book);
    int updateBook(Book book);
    int deleteBookById(int id);
}
