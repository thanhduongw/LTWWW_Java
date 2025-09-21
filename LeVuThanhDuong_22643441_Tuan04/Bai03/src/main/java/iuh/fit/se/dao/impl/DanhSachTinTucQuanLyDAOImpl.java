package iuh.fit.se.dao.impl;

import iuh.fit.se.dao.DanhSachTinTucQuanLyDAO;
import iuh.fit.se.model.DanhMuc;
import iuh.fit.se.model.TinTuc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DanhSachTinTucQuanLyDAOImpl implements DanhSachTinTucQuanLyDAO {

    private final DataSource dataSource;

    public DanhSachTinTucQuanLyDAOImpl(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Override
    public List<DanhMuc> findAllDanhMuc() {
        List<DanhMuc> list = new ArrayList<DanhMuc>();
        String sql = "SELECT MADM, TENDANHMUC, NGUOIQUANLY, GHICHU FROM DANHMUC";
        try(Connection conn = this.dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new DanhMuc(
                        rs.getString("MADM"),
                        rs.getString("TENDANHMUC"),
                        rs.getString("NGUOIQUANLY"),
                        rs.getString("GHICHU")));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public List<TinTuc> findAllTinTucByDanhMuc(DanhMuc danhMuc) {
        List<TinTuc> list = new ArrayList<>();
        String sql = "SELECT MATT, TIEUDE, NOIDUNGTT, LIENKET, MADM FROM TINTUC WHERE MADM = ?";
        try(Connection conn = this.dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, danhMuc.getId());
            try(ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(new TinTuc(
                            rs.getString("MATT"),
                            rs.getString("TIEUDE"),
                            rs.getString("NOIDUNGTT"),
                            rs.getString("LIENKET"),
                            danhMuc
                    ));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public boolean addTinTuc(TinTuc tinTuc) {
        String sql = "INSERT INTO TINTUC(MATT, TIEUDE, NOIDUNGTT, LIENKET, MADM) VALUES (?,?,?,?,?)";
        try(Connection conn = this.dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, tinTuc.getId());
            ps.setString(2, tinTuc.getTitle());
            ps.setString(3, tinTuc.getContent());
            ps.setString(4, tinTuc.getLink());
            ps.setString(5, tinTuc.getDanhMuc().getId());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            return false;

        }
    }

    @Override
    public boolean deleteTinTuc(TinTuc tinTuc) {
        String sql = "DELETE FROM TINTUC WHERE ID = ?";
        try (Connection c = dataSource.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, tinTuc.getId());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
