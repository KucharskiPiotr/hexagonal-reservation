package com.kucharskipiotr.domain;

import com.kucharskipiotr.domain.model.Book;
import com.kucharskipiotr.ports.BookRepository;

class AddBook {
  private BookRepository repository;

  public AddBook(BookRepository repository) {
    this.repository = repository;
  }

  public void add(Book book) {
    repository.save(book);
  }
}
