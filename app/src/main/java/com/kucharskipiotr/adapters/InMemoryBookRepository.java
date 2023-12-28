package com.kucharskipiotr.adapters;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.kucharskipiotr.domain.model.Book;
import com.kucharskipiotr.ports.BookRepository;

public class InMemoryBookRepository implements BookRepository {
  private HashMap<Integer, Book> books = new HashMap<Integer, Book>();

  @Override
  public Book getById(Integer id) {
    return books.get(id);
  }

  @Override
  public void save(Book book) {
    books.put(book.id, book);
  }

  @Override
  public List<Book> getAllBooks() {
    return books.values().stream().collect(Collectors.toList());
  }
}
