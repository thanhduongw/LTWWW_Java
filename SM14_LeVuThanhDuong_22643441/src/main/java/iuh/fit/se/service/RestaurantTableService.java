package iuh.fit.se.service;

import iuh.fit.se.model.RestaurantTable;

import java.util.List;

public interface RestaurantTableService {
    List<RestaurantTable> findAll();

    List<RestaurantTable> findByStatus(Long statusId);

    int numOf(Long statusId);
}
