package iuh.fit.se.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TinTuc {
    private String maTT;
    private String tieuDe;
    private String noiDungTT;
    private String lienKet;
    private DanhMuc danhMuc;

}
