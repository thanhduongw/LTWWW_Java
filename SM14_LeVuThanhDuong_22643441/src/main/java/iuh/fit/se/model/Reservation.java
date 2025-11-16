package iuh.fit.se.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "reservations")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reservationNo;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate reservationDate;
    private String notes;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "table_id")
    @ToString.Exclude
    private RestaurantTable table;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    @ToString.Exclude
    private Customer customer;
}
