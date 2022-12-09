package tech.demirkol.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tech.demirkol.spring5webapp.domain.Author;
import tech.demirkol.spring5webapp.domain.Book;
import tech.demirkol.spring5webapp.domain.Publisher;
import tech.demirkol.spring5webapp.repositories.AuthorRepository;
import tech.demirkol.spring5webapp.repositories.BookRepository;
import tech.demirkol.spring5webapp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherReporsitory;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherReporsitory) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherReporsitory = publisherReporsitory;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Bootstrap starting!");
        Publisher publisher = new Publisher("Oxford");
        publisherReporsitory.save(publisher);

        Author eric = new Author("Eric", "Evens");
        Book book1 = new Book("Domain Driven Dev","1231312");
        eric.getBooks().add(book1);
        book1.getAuthors().add(eric);
        book1.setPublisher(publisher);

        authorRepository.save(eric);
        bookRepository.save(book1);
        publisherReporsitory.save(publisher);

        Author osman = new Author("Osman", "Abi");
        Book book2 = new Book("Osman Driven Dev","121231312");
        osman.getBooks().add(book2);
        book2.getAuthors().add(osman);
        book2.setPublisher(publisher);

        publisher.getBooks().add(book1);
        publisher.getBooks().add(book2);

        authorRepository.save(osman);
        bookRepository.save(book2);
        publisherReporsitory.save(publisher);


        System.out.println("Number of publishers: " + publisherReporsitory.count());
        System.out.println("Number of books: " + publisher.getBooks().size());
    }
}
