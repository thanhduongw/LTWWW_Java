package iuh.fit.se.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DienThoai {
    private String id;
    private String name;
    private int namSanXuat;
    private String cauHinh;
    private String hinhAnh;
    private NhaCungCap nhaCungCap;

}
