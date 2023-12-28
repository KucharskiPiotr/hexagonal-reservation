package com.kucharskipiotr.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.kucharskipiotr.adapters.InMemoryBookRepository;
import com.kucharskipiotr.adapters.MockSyncAdapter;
import com.kucharskipiotr.domain.model.Book;

public class SyncBooksTest {
  @Test
  public void testSync() {
    var memory = new InMemoryBookRepository();
    var sync = new MockSyncAdapter();
    var service = new SyncBooks(memory, sync);

    var book1 = new Book(1, "Hello", null);
    var book2 = new Book(2, "Hello 2", null);
    var book3 = new Book(3, "Hello 3", 1);

    memory.save(book1);
    memory.save(book2);
    memory.save(book3);

    service.sync();

    assertEquals(sync.amount(), new Integer(3));
  }
}
