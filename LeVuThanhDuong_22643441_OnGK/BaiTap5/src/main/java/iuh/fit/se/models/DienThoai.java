package iuh.fit.se.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DienThoai {
    private int maDT;
    private String tenDT;
    private int namSanXuat;
    private String cauHinh;
    private NhaCungCap nhaCungCap;
    private String hinhAnh;
}
