package com.kucharskipiotr.ports;

import com.kucharskipiotr.domain.model.Book;

public interface SyncPort {
  void add(Book book);

  void sync();
}
