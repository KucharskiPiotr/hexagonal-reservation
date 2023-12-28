package com.kucharskipiotr.domain;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.kucharskipiotr.adapters.InMemoryBookRepository;
import com.kucharskipiotr.domain.model.Book;

public class ReserveBookTest {

  @Test
  public void testReserve() {
    var memory = new InMemoryBookRepository();
    var book = new Book(1, "Hello", null);
    var reservedBook = new Book(2, "Hello 2", 3);
    memory.save(book);
    memory.save(reservedBook);

    var service = new ReserveBook(memory);

    assertTrue(service.reserve(1, 1));
    assertFalse(service.reserve(1, 1));
    assertFalse(service.reserve(2, 1));
  }
}
