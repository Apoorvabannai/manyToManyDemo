package com.example.manyToManyDemo.bootstrap;

import com.example.manyToManyDemo.domain.Author;
import com.example.manyToManyDemo.domain.Books;
import com.example.manyToManyDemo.domain.Publisher;
import com.example.manyToManyDemo.repository.AuthorRepository;
import com.example.manyToManyDemo.repository.BooksRepository;
import com.example.manyToManyDemo.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class bootstrapData implements CommandLineRunner {
  private final AuthorRepository authorRepository;
  private final BooksRepository booksRepository;
  private final PublisherRepository publisherRepository;

  public bootstrapData(AuthorRepository authorRepository, BooksRepository booksRepository, PublisherRepository publisherRepository) {
    this.authorRepository = authorRepository;
    this.booksRepository = booksRepository;
    this.publisherRepository = publisherRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    Author apoorva = new Author("Apoorva", "Bannai");
    Books domain_driven_theory = new Books("Domain Driven theory", "1120");
    Publisher publisher = new Publisher();
    publisher.setName("Laxman Publishhing");
    publisher.setCity("Telangana");
    publisher.setState("Hyderabad");
    publisherRepository.save(publisher);
    System.out.println("Publisher Count: " + publisherRepository.count());

    apoorva.getBook().add(domain_driven_theory);
    domain_driven_theory.getAuthors().add(apoorva);

    domain_driven_theory.setPublisher(publisher);
    publisher.getBooks().add(domain_driven_theory);

    authorRepository.save(apoorva);
    booksRepository.save(domain_driven_theory);
    publisherRepository.save(publisher);

    Author Rakesh = new Author("Rakesh", "Sharma");
    Books HtS = new Books("How to suceed", "11121");
    Rakesh.getBook().add(domain_driven_theory);
    Rakesh.getBook().add(HtS);
    HtS.getAuthors().add(Rakesh);
    HtS.setPublisher(publisher);
    publisher.getBooks().add(HtS);

    authorRepository.save(Rakesh);
    booksRepository.save(HtS);
    booksRepository.save(domain_driven_theory);
    publisherRepository.save(publisher);

    System.out.println("The number of Book Count " + booksRepository.count());
    System.out.println("The total number of authors existing are " + authorRepository.count());
    System.out.println("The publisher added are " + publisher.getBooks().size());
  // to connect to the data base we are using H2 in application properties
    // make sure to enable the h2 console(spring.h2.console.enable = true
    // go to port8080/h2-console and check url make sure it matches and connect

  }
}
