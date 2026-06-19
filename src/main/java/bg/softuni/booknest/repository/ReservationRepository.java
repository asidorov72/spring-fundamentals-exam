package bg.softuni.booknest.repository;

import bg.softuni.booknest.model.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, UUID> {
    boolean existsByBookId(UUID bookId);
    boolean existsByBookIdAndUserId(UUID bookId, UUID userId);
}
