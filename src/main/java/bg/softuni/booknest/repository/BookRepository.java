package bg.softuni.booknest.repository;

import bg.softuni.booknest.model.entity.Book;
import bg.softuni.booknest.model.enums.BookStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {
    List<Book> findTop8ByStatusOrderByCreatedOnDesc(BookStatus status);
    List<Book> findTop4ByFeaturedTrueAndStatusOrderByCreatedOnDesc(BookStatus status);
    List<Book> findAllByStatusOrderByRentalPriceDesc(BookStatus status);
}
