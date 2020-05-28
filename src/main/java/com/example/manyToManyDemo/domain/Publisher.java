package com.example.manyToManyDemo.domain;

import org.hibernate.mapping.Join;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Publisher {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  private String addressLine;
  private String city;
  private String state;
  private String zipCode;
  @OneToMany
  @JoinColumn(name= "publisher_id")
  private Set<Books> books = new HashSet<>();

  public Publisher() {
  }

  public Publisher(String laxman, String s, String co, String denver, String s1) {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddressLine() {
    return addressLine;
  }

  public void setAddressLine(String addressLine) {
    this.addressLine = addressLine;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  public Set<Books> getBooks() {
    return books;
  }

  public void setBooks(Set<Books> books) {
    this.books = books;
  }

  public Publisher(Long id, String name, String addressLine, String city, String state, String zipCode) {
    this.id = id;
    this.name = name;
    this.addressLine = addressLine;
    this.city = city;
    this.state = state;
    this.zipCode = zipCode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Publisher publisher = (Publisher) o;
    return Objects.equals(id, publisher.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
