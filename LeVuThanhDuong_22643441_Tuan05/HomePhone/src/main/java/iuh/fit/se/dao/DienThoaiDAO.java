package iuh.fit.se.dao;

import iuh.fit.se.model.DienThoai;
import iuh.fit.se.model.NhaCungCap;

import java.util.List;

public interface DienThoaiDAO {
    public List<DienThoai> findAll();
    public List<DienThoai> findByNCC(NhaCungCap ncc);
    public boolean add(DienThoai dienThoai);
    public boolean delete(String maDT);

}
