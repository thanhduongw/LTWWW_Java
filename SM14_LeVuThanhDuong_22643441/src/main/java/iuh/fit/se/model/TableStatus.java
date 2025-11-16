package iuh.fit.se.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "table_status")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class TableStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String statusName;
    @OneToMany(mappedBy = "status")
    @ToString.Exclude
    private List<RestaurantTable> tables;
}