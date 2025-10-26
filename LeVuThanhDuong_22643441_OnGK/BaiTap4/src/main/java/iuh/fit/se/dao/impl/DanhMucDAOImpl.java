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
    public List<DanhMuc> findAll() {
        List<DanhMuc> list = new ArrayList<DanhMuc>();
        String sql = "SELECT * FROM DANHMUC";
        try(Connection connection = this.dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){

            while (rs.next()){
                DanhMuc danhMuc = new DanhMuc();
                danhMuc.setMaDM(rs.getString("maDM"));
                danhMuc.setTenDanhMuc(rs.getString("tenDanhMuc"));
                danhMuc.setNguoiQuanLy(rs.getString("nguoiQuanLy"));
                danhMuc.setGhiChu(rs.getString("ghiChu"));
                list.add(danhMuc);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public DanhMuc findById(String id) {
        String sql = "SELECT * FROM DANHMUC WHERE maDM = ?";
        try(Connection connection = this.dataSource.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);){
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                DanhMuc danhMuc = new DanhMuc();
                danhMuc.setMaDM(rs.getString("maDM"));
                danhMuc.setTenDanhMuc(rs.getString("tenDanhMuc"));
                danhMuc.setNguoiQuanLy(rs.getString("nguoiQuanLy"));
                danhMuc.setGhiChu(rs.getString("ghiChu"));
                return danhMuc;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean save(DanhMuc danhMuc) {
        String sql = "INSERT INTO DANHMUC (maDM, tenDanhMuc, nguoiQuanLy, ghiChu) VALUES (?,?,?,?)";
        try(Connection connection = this.dataSource.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        ) {
            ps.setString(1, danhMuc.getMaDM());
            ps.setString(2, danhMuc.getTenDanhMuc());
            ps.setString(3, danhMuc.getNguoiQuanLy());
            ps.setString(4, danhMuc.getGhiChu());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        String sql = "DELETE FROM DANHMUC WHERE maDM = ?";
        try(Connection connection = this.dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
        ) {
            ps.setString(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
