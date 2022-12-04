package tech.demirkol.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import tech.demirkol.spring5webapp.domain.Book;

public interface BookRepository extends CrudRepository<Book,Long> {
}
