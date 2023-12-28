package com.kucharskipiotr.domain;

import com.kucharskipiotr.ports.BookRepository;
import com.kucharskipiotr.ports.SyncPort;

class SyncBooks {
  private BookRepository bookRepository;
  private SyncPort syncPort;

  public SyncBooks(BookRepository bookRepository, SyncPort syncPort) {
    this.bookRepository = bookRepository;
    this.syncPort = syncPort;
  }

  public void sync() {
    bookRepository.getAllBooks().forEach(book -> {
      syncPort.add(book);
    });
    syncPort.sync();
  }
}
