package iuh.fit.se.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String id;
    @NotNull(message = "Họ tên không được để trống")
    @NotEmpty(message = "Họ tên không được để trống")
    private String name;
    @NotNull(message = "Ngày sinh không được để trống")
    @NotEmpty(message = "Ngày sinh không được để trống")
    private LocalDate dob;
    @NotNull(message = "Điểm không được để trống")
    @NotEmpty(message = "Điểm không được để trống")
    private double score;
    @ToString.Exclude
    private Clazz clazz;
}
