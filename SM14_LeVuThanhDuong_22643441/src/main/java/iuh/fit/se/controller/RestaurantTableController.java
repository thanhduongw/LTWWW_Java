package iuh.fit.se.controller;

import iuh.fit.se.model.Reservation;
import iuh.fit.se.model.RestaurantTable;
import iuh.fit.se.model.TableStatus;
import iuh.fit.se.service.ReservationService;
import iuh.fit.se.service.RestaurantTableService;
import iuh.fit.se.service.TableStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/table")
public class RestaurantTableController {
    @Autowired
    private RestaurantTableService restaurantTableService;
    @Autowired
    private TableStatusService tableStatusService;
    @Autowired
    ReservationService reservationService;

    @GetMapping("")
    public String showTable(Model model,
                            @RequestParam(required = false) Long statusId){
        List<RestaurantTable> restaurantTables;
        if(statusId != null){
            TableStatus tableStatus = tableStatusService.findById(statusId);
            if(tableStatus!=null){
                restaurantTables = restaurantTableService.findByStatus(statusId);
            } else{
                restaurantTables = restaurantTableService.findAll();
            }
        }else{
            restaurantTables = restaurantTableService.findAll();
        }
        model.addAttribute("restaurantTables", restaurantTables);
        model.addAttribute("tableStatus", tableStatusService.findAll());
        model.addAttribute("selected", statusId);
        model.addAttribute("numOf", restaurantTables.size());
        return "restaurant-table-list";
    }

}
