package iuh.fit.se.daos;

import iuh.fit.se.models.DienThoai;

import java.util.List;

public interface DienThoaiDAO {
    List<DienThoai> findAll();
    List<DienThoai> findByMaNCC(int maNCC);
    boolean add(DienThoai dienThoai);
    boolean update(DienThoai dienThoai);
    boolean delete(String id);
}
