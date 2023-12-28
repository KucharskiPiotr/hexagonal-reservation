package com.kucharskipiotr.domain;

import com.kucharskipiotr.ports.BookRepository;

class ReserveBook {
  private BookRepository bookRepository;

  public ReserveBook(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  public boolean reserve(Integer bookId, Integer requesterId) {
    var book = bookRepository.getById(bookId);
    if (book.isAlreadyReserved()) {
      return false;
    }

    book.reservedBy = requesterId;
    bookRepository.save(book);
    return true;
  }
}
