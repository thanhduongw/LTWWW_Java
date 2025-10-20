package iuh.fit.se.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TinTuc {
    private int maTinTuc;
    @NotNull(message = "Tiêu đề không được để trống")
    @NotEmpty(message = "Tiêu đề không được để trống")
    private String tieuDe;
    @NotNull(message = "Nội dung không được để trống")
    @NotEmpty(message = "Nội dung không được để trống")
    @Size(max = 255, message = "Nội dung không quá 255 ký tự")
    private String noiDung;
    @NotNull(message = "Liên kết không được để trống")
    @NotEmpty(message = "Liên kết không được để trống")
    @Pattern(regexp = "^http://.*", message = "Liên kết phải bắt đầu bằng http://")
    private String lienKet;

    @ToString.Exclude
    private DanhMuc danhMuc;
}
