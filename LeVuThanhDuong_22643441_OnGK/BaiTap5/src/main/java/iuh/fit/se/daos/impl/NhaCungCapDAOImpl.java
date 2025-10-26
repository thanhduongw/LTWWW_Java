package iuh.fit.se.daos.impl;

import iuh.fit.se.daos.NhaCungCapDAO;
import iuh.fit.se.models.NhaCungCap;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NhaCungCapDAOImpl implements NhaCungCapDAO {

    private DataSource dataSource;

    public NhaCungCapDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<NhaCungCap> findAll() {
        List<NhaCungCap> list = new ArrayList<>();
        String sql="SELECT * FROM nhacungcap";
        try(Connection connection = this.dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
            while(rs.next()){
                NhaCungCap ncc = new NhaCungCap();
                ncc.setMaNCC(rs.getInt("mancc"));
                ncc.setTenNCC(rs.getString("tennhacc"));
                ncc.setDiaChi(rs.getString("diachi"));
                ncc.setSoDienThoai(rs.getString("sodienthoai"));
                list.add(ncc);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public NhaCungCap search(String keyword) {
        String sql = "SELECT * FROM NHACUNGCAP WHERE MANCC LIKE ? OR tennhacc LIKE ? OR diachi LIKE ? OR soththoai LIKE ?";
        try(Connection connection = this.dataSource.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)){
            String likeKeyWord = "%" + keyword + "%";
            ps.setString(1, likeKeyWord);
            ps.setString(2, likeKeyWord);
            ps.setString(3, likeKeyWord);
            ps.setString(4, likeKeyWord);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                NhaCungCap ncc = new NhaCungCap();
                ncc.setMaNCC(rs.getInt("mancc"));
                ncc.setTenNCC(rs.getString("tennhacc"));
                ncc.setDiaChi(rs.getString("diachi"));
                ncc.setSoDienThoai(rs.getString("sodienthoai"));
                return ncc;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public NhaCungCap findById(int id) {
        String sql = "SELECT * FROM NHACUNGCAP WHERE MANCC = ?";
        try(Connection connection = this.dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                NhaCungCap ncc = new NhaCungCap();
                ncc.setMaNCC(rs.getInt("mancc"));
                ncc.setTenNCC(rs.getString("tennhacc"));
                ncc.setDiaChi(rs.getString("diachi"));
                ncc.setSoDienThoai(rs.getString("sodienthoai"));
                return ncc;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
