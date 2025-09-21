package iuh.fit.se.dao;

import iuh.fit.se.model.DanhMuc;
import iuh.fit.se.model.TinTuc;

import java.util.List;

public interface DanhSachTinTucQuanLyDAO {
    public List<DanhMuc> findAllDanhMuc();
    public List<TinTuc> findAllTinTucByDanhMuc(DanhMuc danhMuc);
    public boolean addTinTuc(TinTuc tinTuc);
    public boolean deleteTinTuc(TinTuc tinTuc);
}
