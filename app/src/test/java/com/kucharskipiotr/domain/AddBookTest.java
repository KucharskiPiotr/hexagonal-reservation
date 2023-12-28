package com.kucharskipiotr.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.kucharskipiotr.adapters.InMemoryBookRepository;
import com.kucharskipiotr.domain.model.Book;

public class AddBookTest {
  @Test
  public void testAdd() {
    var memory = new InMemoryBookRepository();
    var service = new AddBook(memory);
    var book = new Book(1, "Hello", null);

    service.add(book);

    var savedBooks = memory.getAllBooks();
    assertEquals(savedBooks.size(), 1);
    assertEquals(savedBooks.get(0).id, book.id);
  }
}
