package guru.springframework.spring5webapplication.repositories;

import guru.springframework.spring5webapplication.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
