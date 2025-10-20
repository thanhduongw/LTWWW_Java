package iuh.fit.se.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DanhMuc {
    private int maDanhMuc;
    private String tenDanhMuc;
    private String nguoiQuanLy;
    private String ghiChu;
}
