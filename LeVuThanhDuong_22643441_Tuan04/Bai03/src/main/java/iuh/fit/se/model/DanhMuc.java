package iuh.fit.se.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.N;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DanhMuc {
    private String id;
    private String name;
    private String manager;
    private String note;
}
