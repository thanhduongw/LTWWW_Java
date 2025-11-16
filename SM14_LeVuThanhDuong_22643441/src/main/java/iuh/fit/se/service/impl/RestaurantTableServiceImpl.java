package iuh.fit.se.service.impl;

import iuh.fit.se.model.Reservation;
import iuh.fit.se.model.RestaurantTable;
import iuh.fit.se.model.TableStatus;
import iuh.fit.se.repository.ReservationRepository;
import iuh.fit.se.repository.RestaurantTableRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantTableServiceImpl implements iuh.fit.se.service.RestaurantTableService {
    RestaurantTableRepository restaurantTableRepository;

    public RestaurantTableServiceImpl(RestaurantTableRepository restaurantTableRepository) {
        this.restaurantTableRepository = restaurantTableRepository;
    }

    @Override
    public List<RestaurantTable> findAll(){
        return restaurantTableRepository.findAll();
    }

    @Override
    public List<RestaurantTable> findByStatus(Long statusId){
        return restaurantTableRepository.findByStatus(statusId);
    }
    @Override
    public int numOf(Long statusId){
        return restaurantTableRepository.findByStatus(statusId).size();
    }
}
