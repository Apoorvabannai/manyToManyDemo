package com.example.manyToManyDemo.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
@Entity
public class Books {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String title;
  private String isbn;
  @ManyToOne
  private Publisher publisher;
  @ManyToMany
  @JoinTable(name = "author_book", joinColumns =@JoinColumn(name = "books_id"),
          inverseJoinColumns = @JoinColumn(name = "authors_id"))
  private Set<Author> authors = new HashSet<>();

  public Books() {
  }

  public Books(String title, String isbn) {
    this.title = title;
    this.isbn = isbn;
  }

  public Publisher getPublisher() {
    return publisher;
  }

  public void setPublisher(Publisher publisher) {
    this.publisher = publisher;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public Set<Author> getAuthors() {
    return authors;
  }

  public void setAuthors(Set<Author> authors) {
    this.authors = authors;
  }

  @Override
  public String toString() {
    return "Books{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", isbn='" + isbn + '\'' +
            ", authors=" + authors +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Books books = (Books) o;
    return Objects.equals(id, books.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
