package com.example.manyToManyDemo.repository;

import com.example.manyToManyDemo.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {

}
