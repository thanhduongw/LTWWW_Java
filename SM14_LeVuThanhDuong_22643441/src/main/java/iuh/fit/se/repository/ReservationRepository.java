package iuh.fit.se.repository;

import iuh.fit.se.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Query(value = "SELECT * FROM reservations r WHERE r.table_id = :tableId", nativeQuery = true)
    Reservation findByTable(@Param("tableId") Long tableId);
}
