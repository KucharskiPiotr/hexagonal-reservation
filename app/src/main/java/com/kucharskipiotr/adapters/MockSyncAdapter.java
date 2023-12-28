package com.kucharskipiotr.adapters;

import java.util.ArrayList;
import java.util.List;

import com.kucharskipiotr.domain.model.Book;
import com.kucharskipiotr.ports.SyncPort;

public class MockSyncAdapter implements SyncPort {

  private List<Book> books = new ArrayList<Book>();

  @Override
  public void add(Book book) {
    books.add(book);
  }

  @Override
  public void sync() {
    System.out.println("Synced!");
  }

  public Integer amount() {
    return books.size();
  }
}
