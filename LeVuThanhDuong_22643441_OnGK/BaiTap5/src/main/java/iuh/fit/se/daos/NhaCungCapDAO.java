package iuh.fit.se.daos;

import iuh.fit.se.models.NhaCungCap;

import java.util.List;

public interface NhaCungCapDAO {
    List<NhaCungCap> findAll();
    NhaCungCap search(String keyword);
    NhaCungCap findById(int id);
}
