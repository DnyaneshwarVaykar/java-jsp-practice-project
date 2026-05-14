package com.dao;

import java.util.List;

import com.entity.Book;

public interface BookDao {

	void addBook(Book book);

	void updateBook(Book book);

	void deleteBook(Book book);

	void deleteBookById(int id);

	Book getBookById(int id);

	List<Book> getAllBooks();

}