package iuh.fit.se.dao.impl;

import iuh.fit.se.dao.NhaCungCapDAO;
import iuh.fit.se.model.NhaCungCap;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NhaCungCapDAOImpl implements NhaCungCapDAO {

    private final DataSource dataSource;

    public NhaCungCapDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<NhaCungCap> findAll() {
        String sql = "SELECT MANCC, TENNHACC, DIACHI, SODIENTHOAI FROM NHACUNGCAP";
        List<NhaCungCap> list = new ArrayList<NhaCungCap>();

        try(Connection connection = this.dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
            while (rs.next()){
                list.add(new NhaCungCap(
                        rs.getString("MANCC"),
                        rs.getString("TENNHACC"),
                        rs.getString("DIACHI"),
                        rs.getString("SODIENTHOAI")
                ));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<NhaCungCap> search(String keyword) {
        String sql = "" +
                "SELECT MANCC, TENNHACC, DIACHI, SODIENTHOAI " +
                "FROM NHACUNGCAP" +
                "WHERE MANCC LIKE ? OR TENNHACC LIKE ? OR DIACHI LIKE ? OR SODIENTHOAI LIKE ?";
        List<NhaCungCap> list = new ArrayList<>();
        try(Connection connection = this.dataSource.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1,keyword);
            ps.setString(2,keyword);
            ps.setString(3,keyword);
            ps.setString(4,keyword);
            try(ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    list.add(new NhaCungCap(
                            rs.getString("MANCC"),
                            rs.getString("TENNHACC"),
                            rs.getString("DIACHI"),
                            rs.getString("SODIENTHOAI")
                    ));
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return list;
    }
}
