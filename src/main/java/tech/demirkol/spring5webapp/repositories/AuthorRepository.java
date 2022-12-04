package tech.demirkol.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import tech.demirkol.spring5webapp.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
