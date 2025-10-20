package iuh.fit.se.dao;

import iuh.fit.se.model.TinTuc;

import java.util.List;

public interface TinTucDAO {
    List<TinTuc> findAll();
    List<TinTuc> findByDanhMuc(int maDanhMuc);
    TinTuc findById(int maTinTuc);
    boolean save(TinTuc tinTuc);
    boolean delete(int maTinTuc);
}
