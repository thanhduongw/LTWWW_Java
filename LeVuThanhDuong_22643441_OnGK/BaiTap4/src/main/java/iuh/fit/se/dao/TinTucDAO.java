package iuh.fit.se.dao;

import iuh.fit.se.model.TinTuc;

import java.util.List;

public interface TinTucDAO {
    List<TinTuc> findAll();
    List<TinTuc> findByDanhMuc(String maDM);
    TinTuc findById(String id);
    boolean save(TinTuc tinTuc);
    boolean delete(String id);
}
