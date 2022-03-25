package guru.springframework.spring5webapplication.repositories;

import guru.springframework.spring5webapplication.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
