package tech.demirkol.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import tech.demirkol.spring5webapp.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
