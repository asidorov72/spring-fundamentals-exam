package bg.softuni.booknest.service;

import bg.softuni.booknest.model.entity.Book;
import bg.softuni.booknest.model.entity.Reservation;
import bg.softuni.booknest.model.entity.Transaction;
import bg.softuni.booknest.model.entity.User;
import bg.softuni.booknest.model.enums.BookStatus;
import bg.softuni.booknest.model.enums.TransactionStatus;
import bg.softuni.booknest.repository.BookRepository;
import bg.softuni.booknest.repository.ReservationRepository;
import bg.softuni.booknest.repository.TransactionRepository;
import bg.softuni.booknest.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final TransactionRepository transactionRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public ReservationService(ReservationRepository reservationRepository,
                              TransactionRepository transactionRepository,
                              BookRepository bookRepository,
                              UserRepository userRepository) {
        this.reservationRepository = reservationRepository;
        this.transactionRepository = transactionRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void reserveBook(UUID bookId, UUID userId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));

        if (book.getStatus() != BookStatus.ACTIVE) {
            throw new IllegalStateException("Book is not available for reservation");
        }

        if (reservationRepository.existsByBookIdAndUserId(bookId, userId)) {
            throw new IllegalStateException("You have already reserved this book");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Reservation reservation = new Reservation()
                .setUser(user)
                .setBook(book)
                .setReservationDate(LocalDate.now())
                .setReturnDate(LocalDate.now().plusDays(14));

        reservationRepository.save(reservation);

        Transaction transaction = new Transaction()
                .setUser(user)
                .setReservation(reservation)
                .setAmount(book.getRentalPrice())
                .setStatus(TransactionStatus.SUCCESSFUL);

        transactionRepository.save(transaction);
    }

    public boolean isReservedByCurrentUser(UUID bookId, UUID userId) {
        return reservationRepository.existsByBookIdAndUserId(bookId, userId);
    }
}