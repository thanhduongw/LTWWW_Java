package iuh.fit.se.dao;

import iuh.fit.se.model.DanhMuc;

import java.util.List;

public interface DanhMucDAO {
    List<DanhMuc> findAll();
    DanhMuc findById(String id);
    boolean save(DanhMuc danhMuc);
    boolean delete(String id);
}
