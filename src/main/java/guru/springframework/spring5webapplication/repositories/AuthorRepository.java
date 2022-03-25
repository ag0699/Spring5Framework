package guru.springframework.spring5webapplication.repositories;

import guru.springframework.spring5webapplication.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
