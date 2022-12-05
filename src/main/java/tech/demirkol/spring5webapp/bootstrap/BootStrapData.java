package tech.demirkol.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tech.demirkol.spring5webapp.domain.Author;
import tech.demirkol.spring5webapp.domain.Book;
import tech.demirkol.spring5webapp.repositories.AuthorRepository;
import tech.demirkol.spring5webapp.repositories.BookRepository;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evens");
        Book book1 = new Book("Domain Driven Dev","1231312");
        eric.getBooks().add(book1);
        book1.getAuthors().add(eric);

        Author osman = new Author("Osman", "Abi");
        Book book2 = new Book("Osman Driven Dev","121231312");
        osman.getBooks().add(book2);
        book1.getAuthors().add(osman);

        authorRepository.save(eric);
        authorRepository.save(osman);

        bookRepository.save(book1);
        bookRepository.save(book2);

        System.out.println("Bootstrap starting!");
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of author: " + authorRepository.count());
    }
}
