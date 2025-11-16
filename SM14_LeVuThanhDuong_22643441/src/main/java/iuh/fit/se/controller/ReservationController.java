package iuh.fit.se.controller;

import iuh.fit.se.model.Reservation;
import iuh.fit.se.model.RestaurantTable;
import iuh.fit.se.model.TableStatus;
import iuh.fit.se.service.ReservationService;
import iuh.fit.se.service.RestaurantTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    ReservationService reservationService;
    @Autowired
    RestaurantTableService restaurantTableService;

    @GetMapping("")
    public String showTable(Model model){
        model.addAttribute("reservations", reservationService.findAll());
        return "reservation-list";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        reservationService.delete(id);
        return "redirect:/reservation";
    }

    @PostMapping("")
    public String saveForm(Reservation reservation, Model model) {
        reservationService.save(reservation);
        return "redirect:/reservation";
    }


    @GetMapping("/form")
    public String showForm(Model model) {
        return "reservation-form";
    }

}
