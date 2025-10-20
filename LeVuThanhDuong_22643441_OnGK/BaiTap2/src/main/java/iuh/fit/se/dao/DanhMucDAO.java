package iuh.fit.se.dao;

import iuh.fit.se.model.DanhMuc;

import java.util.List;

public interface DanhMucDAO {
    List<DanhMuc> findAll();
    DanhMuc findById(int maDanhMuc);
    boolean save(DanhMuc danhMuc);
    boolean delete(int maDanhMuc);
}
