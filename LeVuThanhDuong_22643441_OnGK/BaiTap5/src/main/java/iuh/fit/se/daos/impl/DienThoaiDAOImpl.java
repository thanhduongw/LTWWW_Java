package iuh.fit.se.daos.impl;

import iuh.fit.se.daos.DienThoaiDAO;
import iuh.fit.se.daos.NhaCungCapDAO;
import iuh.fit.se.models.DienThoai;
import iuh.fit.se.models.NhaCungCap;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DienThoaiDAOImpl implements DienThoaiDAO {
    private DataSource dataSource;
    private NhaCungCapDAO nhaCungCapDAO;

    public DienThoaiDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
        this.nhaCungCapDAO = new NhaCungCapDAOImpl(dataSource);
    }

    @Override
    public List<DienThoai> findAll() {
        List<DienThoai> dienThoaiList = new ArrayList<>();
        String sql = "SELECT * FROM DIENTHOAI";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                DienThoai dienThoai = new DienThoai();
                dienThoai.setMaDT(rs.getInt("madt"));
                dienThoai.setTenDT(rs.getString("tendt"));
                dienThoai.setNamSanXuat(rs.getInt("namsanxuat"));
                dienThoai.setCauHinh(rs.getString("cauhinh"));
                dienThoai.setHinhAnh(rs.getString("hinhanh"));

                NhaCungCap ncc = nhaCungCapDAO.findById(rs.getInt("mancc"));
                dienThoai.setNhaCungCap(ncc);

                dienThoaiList.add(dienThoai);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dienThoaiList;
    }

    @Override
    public List<DienThoai> findByMaNCC(int maNCC) {
        List<DienThoai> dienThoaiList = new ArrayList<>();
        String sql = "SELECT * FROM DIENTHOAI WHERE MANCC = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, maNCC);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                DienThoai dienThoai = new DienThoai();
                dienThoai.setMaDT(rs.getInt("madt"));
                dienThoai.setTenDT(rs.getString("tendt"));
                dienThoai.setNamSanXuat(rs.getInt("namsanxuat"));
                dienThoai.setCauHinh(rs.getString("cauhinh"));
                dienThoai.setHinhAnh(rs.getString("hinhanh"));

                NhaCungCap ncc = nhaCungCapDAO.findById(rs.getInt("mancc"));
                dienThoai.setNhaCungCap(ncc);

                dienThoaiList.add(dienThoai);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dienThoaiList;
    }

    @Override
    public boolean add(DienThoai dienThoai) {
        String sql = "INSERT INTO DIENTHOAI (TENDT, NAMSANXUAT, CAUHINH, MANCC, HINHANH) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, dienThoai.getTenDT());
            ps.setInt(2, dienThoai.getNamSanXuat());
            ps.setString(3, dienThoai.getCauHinh());
            ps.setInt(4, dienThoai.getNhaCungCap().getMaNCC());
            ps.setString(5, dienThoai.getHinhAnh());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(DienThoai dienThoai) {
        String sql = "UPDATE DIENTHOAI SET TENDT = ?, NAMSANXUAT = ?, CAUHINH = ?, MANCC = ?, HINHANH = ? WHERE MADT = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, dienThoai.getTenDT());
            ps.setInt(2, dienThoai.getNamSanXuat());
            ps.setString(3, dienThoai.getCauHinh());
            ps.setInt(4, dienThoai.getNhaCungCap().getMaNCC());
            ps.setString(5, dienThoai.getHinhAnh());
            ps.setInt(6, dienThoai.getMaDT());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        String sql = "DELETE FROM DIENTHOAI WHERE MADT = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, Integer.parseInt(id));
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
