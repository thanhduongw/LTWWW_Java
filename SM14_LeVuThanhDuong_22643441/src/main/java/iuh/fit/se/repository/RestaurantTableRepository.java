package iuh.fit.se.repository;

import iuh.fit.se.model.Reservation;
import iuh.fit.se.model.RestaurantTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantTableRepository extends JpaRepository<RestaurantTable, Long> {
    @Query(value = "SELECT * FROM restaurant_tables rt WHERE rt.status_id = :statusId",nativeQuery = true)
    List<RestaurantTable> findByStatus(@Param("statusId") Long statusId);
}
