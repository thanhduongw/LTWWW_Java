package iuh.fit.se.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TinTuc {
    private String id;
    private String title;
    private String content;
    private String link;
    private DanhMuc danhMuc;

}
