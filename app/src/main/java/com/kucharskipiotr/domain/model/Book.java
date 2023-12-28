package com.kucharskipiotr.domain.model;

public class Book {
  public Integer id;
  public String name;
  public Integer reservedBy;

  public Book(Integer id, String name, Integer reservedBy) {
    this.id = id;
    this.name = name;
    this.reservedBy = reservedBy;
  }

  public boolean isAlreadyReserved() {
    return reservedBy != null;
  }
}
