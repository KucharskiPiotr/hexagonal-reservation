package com.kucharskipiotr.ports;

import java.util.List;

import com.kucharskipiotr.domain.model.Book;

public interface BookRepository {
  Book getById(Integer id);

  void save(Book book);

  List<Book> getAllBooks();
}