package guru.springframework.spring5webapplication.bootstrap;

import guru.springframework.spring5webapplication.domain.Author;
import guru.springframework.spring5webapplication.domain.Book;
import guru.springframework.spring5webapplication.domain.Publisher;
import guru.springframework.spring5webapplication.repositories.AuthorRepository;
import guru.springframework.spring5webapplication.repositories.BookRepository;
import guru.springframework.spring5webapplication.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private  final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher();
        publisher.setName("Ayu Publishing");
        publisher.setCity("Panchkula");
        publisher.setState("Haryana");

        publisherRepository.save(publisher);

        System.out.println("Started in BootStrap");
        System.out.println("Count of Publishers: "+publisherRepository.count());

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "3939459459");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        System.out.println("Count of Books: "+bookRepository.count());
        System.out.println("Publisher Count of Books: "+ publisher.getBooks().size());


    }
}
