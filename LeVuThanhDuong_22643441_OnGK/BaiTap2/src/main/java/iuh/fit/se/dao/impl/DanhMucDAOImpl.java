package iuh.fit.se.dao.impl;

import iuh.fit.se.dao.DanhMucDAO;
import iuh.fit.se.model.DanhMuc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DanhMucDAOImpl implements DanhMucDAO {

    private DataSource dataSource;

    public DanhMucDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public DanhMuc findById(int maDanhMuc) {
        String sql = "SELECT * FROM DANHMUC WHERE MADM =?";
        try(Connection connection = dataSource.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, maDanhMuc);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                DanhMuc danhMuc = new DanhMuc();
                danhMuc.setMaDanhMuc(rs.getInt("MADM"));
                danhMuc.setTenDanhMuc(rs.getString("TenDanhMuc"));
                danhMuc.setNguoiQuanLy(rs.getString("NguoiQuanLy"));
                danhMuc.setGhiChu(rs.getString("GhiChu"));
                return danhMuc;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<DanhMuc> findAll() {
        List<DanhMuc> list = new ArrayList<>();
        String sql = "SELECT * FROM DANHMUC";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                DanhMuc dm = new DanhMuc();
                dm.setMaDanhMuc(rs.getInt("MADM"));
                dm.setTenDanhMuc(rs.getString("TenDanhMuc"));
                dm.setNguoiQuanLy(rs.getString("NguoiQuanLy"));
                dm.setGhiChu(rs.getString("GhiChu"));
                list.add(dm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean save(DanhMuc danhMuc) {
        String sql = "INSERT INTO DANHMUC (TenDanhMuc, NguoiQuanLy, GhiChu) VALUES (?, ?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, danhMuc.getTenDanhMuc());
            ps.setString(2, danhMuc.getNguoiQuanLy());
            ps.setString(3, danhMuc.getGhiChu());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int maDanhMuc) {
        String sql = "DELETE FROM DANHMUC WHERE MADM = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, maDanhMuc);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
