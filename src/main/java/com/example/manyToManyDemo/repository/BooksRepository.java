package com.example.manyToManyDemo.repository;

import com.example.manyToManyDemo.domain.Books;
import org.springframework.data.repository.CrudRepository;

public interface BooksRepository extends CrudRepository<Books,Long> {

}
