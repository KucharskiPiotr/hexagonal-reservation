package com.kucharskipiotr.domain;

import com.kucharskipiotr.domain.model.Book;
import com.kucharskipiotr.ports.BookRepository;
import com.kucharskipiotr.ports.SyncPort;

public class BooksService {
  private AddBook addBook;
  private ReserveBook reserveBook;
  private SyncBooks syncBooks;

  public BooksService(BookRepository repository, SyncPort syncAdapter) {
    this.addBook = new AddBook(repository);
    this.reserveBook = new ReserveBook(repository);
    this.syncBooks = new SyncBooks(repository, syncAdapter);
  }

  public void addBook(Book book) {
    this.addBook.add(book);
  }

  public boolean reserveBook(Integer bookId, Integer requesterId) {
    return this.reserveBook.reserve(bookId, requesterId);
  }

  public void syncAllBooks() {
    this.syncBooks.sync();
  }
}
