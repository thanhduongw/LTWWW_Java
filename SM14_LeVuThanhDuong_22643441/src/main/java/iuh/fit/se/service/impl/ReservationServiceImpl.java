package iuh.fit.se.service.impl;

import iuh.fit.se.model.Reservation;
import iuh.fit.se.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements iuh.fit.se.service.ReservationService {

    ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> findAll(){
        return reservationRepository.findAll();
    }

    @Override
    public Reservation findByTable(Long tableId){
        return reservationRepository.findByTable(tableId);
    }

    @Override
    public void save(Reservation reservation){
        reservationRepository.save(reservation);
    }

    @Override
    public void delete(Long id){
        reservationRepository.deleteById(id);
    }
}
