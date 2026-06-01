package bg.softuni.booknest.seed;

import bg.softuni.booknest.model.entity.Book;
import bg.softuni.booknest.model.enums.BookStatus;
import bg.softuni.booknest.model.enums.Genre;
import bg.softuni.booknest.repository.BookRepository;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Order(2)
public class BookSeeder implements Seeder {

    private final BookRepository bookRepository;

    public BookSeeder(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void seed() {
        if (bookRepository.count() > 0) {
            return;
        }

        bookRepository.save(
                new Book()
                        .setTitle("The Hobbit")
                        .setAuthor("J.R.R. Tolkien")
                        .setDescription("Bilbo Baggins goes on an unexpected adventure.")
                        .setGenre(Genre.FANTASY)
                        .setStatus(BookStatus.ACTIVE)
                        .setReleaseYear(1937)
                        .setRentalPrice(BigDecimal.valueOf(4.99))
        );

        bookRepository.save(
                new Book()
                        .setTitle("Dune")
                        .setAuthor("Frank Herbert")
                        .setDescription("Epic science fiction saga.")
                        .setGenre(Genre.SCIENCE_FICTION)
                        .setStatus(BookStatus.ACTIVE)
                        .setReleaseYear(1965)
                        .setRentalPrice(BigDecimal.valueOf(5.99))
        );

        bookRepository.save(
                new Book()
                        .setTitle("Romeo and Juliet")
                        .setAuthor("William Shakespeare")
                        .setDescription("Classic romantic tragedy.")
                        .setGenre(Genre.ROMANCE)
                        .setStatus(BookStatus.ACTIVE)
                        .setReleaseYear(1597)
                        .setRentalPrice(BigDecimal.valueOf(3.99))
        );

        bookRepository.save(
                new Book()
                        .setTitle("Hamlet")
                        .setAuthor("William Shakespeare")
                        .setDescription("One of the greatest dramas ever written.")
                        .setGenre(Genre.DRAMA)
                        .setStatus(BookStatus.ACTIVE)
                        .setReleaseYear(1603)
                        .setRentalPrice(BigDecimal.valueOf(3.99))
        );

        bookRepository.save(
                new Book()
                        .setTitle("The Da Vinci Code")
                        .setAuthor("Dan Brown")
                        .setDescription("Mystery thriller novel.")
                        .setGenre(Genre.THRILLER)
                        .setStatus(BookStatus.ACTIVE)
                        .setReleaseYear(2003)
                        .setRentalPrice(BigDecimal.valueOf(5.49))
        );

        bookRepository.save(
                new Book()
                        .setTitle("Sapiens")
                        .setAuthor("Yuval Noah Harari")
                        .setDescription("A brief history of humankind.")
                        .setGenre(Genre.HISTORY)
                        .setStatus(BookStatus.ACTIVE)
                        .setReleaseYear(2011)
                        .setRentalPrice(BigDecimal.valueOf(6.49))
        );
    }
}