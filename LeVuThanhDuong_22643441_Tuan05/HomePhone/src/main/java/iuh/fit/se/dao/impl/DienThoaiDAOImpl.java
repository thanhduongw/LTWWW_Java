package iuh.fit.se.dao.impl;

import iuh.fit.se.dao.DienThoaiDAO;
import iuh.fit.se.model.DienThoai;
import iuh.fit.se.model.NhaCungCap;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DienThoaiDAOImpl implements DienThoaiDAO {

    private final DataSource dataSource;

    public DienThoaiDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<DienThoai> findAll() {
        String sql = "SELECT MADT, TENDT, NAMSANXUAT, CAUHINH, HINHANH, MANCC FROM DIENTHOAI";
        List<DienThoai> list = new ArrayList<DienThoai>();

        try(Connection connection = this.dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
            while (rs.next()){
                NhaCungCap ncc = new NhaCungCap();
                ncc.setId(rs.getString("MANCC"));
                list.add(new DienThoai(
                        rs.getString("MADT"),
                        rs.getString("TENDT"),
                        rs.getInt("NAMSANXUAT"),
                        rs.getString("CAUHINH"),
                        rs.getString("HINHANH"),
                        ncc
                ));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<DienThoai> findByNCC(NhaCungCap ncc) {
        String sql = "SELECT MADT, TENDT, NAMSANXUAT, CAUHINH, HINHANH, MANCC " +
                "FROM DIENTHOAI" +
                "WHERE MANCC = ?";
        List<DienThoai> list = new ArrayList<DienThoai>();

        try(Connection connection = this.dataSource.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1,ncc.getId());
            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    list.add(new DienThoai(
                            rs.getString("MADT"),
                            rs.getString("TENDT"),
                            rs.getInt("NAMSANXUAT"),
                            rs.getString("CAUHINH"),
                            rs.getString("HINHANH"),
                            ncc
                    ));
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean add(DienThoai dienThoai) {
        String sql = "INSERT INTO DIENTHOAI(MADT, TENDT, NAMSANXUAT, CAUHINH, HINHANH, MANCC) VALUES (?,?,?,?,?,?)";
        try(Connection connection = this.dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1,dienThoai.getId());
            ps.setString(2,dienThoai.getName());
            ps.setInt(3,dienThoai.getNamSanXuat());
            ps.setString(4,dienThoai.getCauHinh());
            ps.setString(5,dienThoai.getHinhAnh());
            ps.setString(6,dienThoai.getNhaCungCap().getId());
            return ps.executeUpdate()>0;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(String maDT) {
        String sql = "DELETE FROM DIENTHOAI WHERE MADT = ?";
        try(Connection connection = this.dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1,maDT);
            return ps.executeUpdate()>0;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
