package iuh.fit.se.service;

import iuh.fit.se.model.Reservation;

import java.util.List;

public interface ReservationService {
    void save(Reservation reservation);
    List<Reservation> findAll();

    void delete(Long id);
    Reservation findByTable(Long tableId);
}
