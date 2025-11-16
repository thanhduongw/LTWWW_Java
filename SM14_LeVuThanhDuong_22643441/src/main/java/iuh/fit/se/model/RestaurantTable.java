package iuh.fit.se.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "restaurant_tables")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class RestaurantTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tableNumber;
    private Integer capacity;
    @ManyToOne
    @JoinColumn(name = "status_id")
    @ToString.Exclude
    private TableStatus status;
    @OneToMany(mappedBy = "table",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Reservation> reservations;
}
