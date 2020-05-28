package com.example.manyToManyDemo.repository;

import com.example.manyToManyDemo.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {

}
