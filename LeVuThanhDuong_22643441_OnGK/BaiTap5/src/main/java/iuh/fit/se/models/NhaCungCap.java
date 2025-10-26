package iuh.fit.se.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NhaCungCap {
    private int maNCC;
    private String tenNCC;
    private String diaChi;
    private String soDienThoai;
}
