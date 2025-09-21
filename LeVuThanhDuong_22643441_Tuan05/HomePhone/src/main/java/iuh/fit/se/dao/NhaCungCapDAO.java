package iuh.fit.se.dao;

import iuh.fit.se.model.NhaCungCap;

import java.util.List;

public interface NhaCungCapDAO {
    public List<NhaCungCap> findAll();
    public List<NhaCungCap> search(String keyword);
}
