package iuh.fit.se.dao.impl;

import iuh.fit.se.dao.ClazzDAO;
import iuh.fit.se.model.Clazz;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClazzDAOImpl implements ClazzDAO {

    private DataSource dataSource;

    public ClazzDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Clazz> findAll() {
        List<Clazz> list = new ArrayList<>();
        String sql = "SELECT * FROM lop";
        try(Connection connection = this.dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
            while (rs.next()){
                Clazz clazz = new Clazz();
                clazz.setId(rs.getString("malop"));
                clazz.setName(rs.getString("tenlop"));
                list.add(clazz);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Clazz findById(String id) {
        String sql = "SELECT * FROM lop WHERE malop = ?";
        try(Connection connection= this.dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Clazz clazz = new Clazz();
                clazz.setId(rs.getString("malop"));
                clazz.setName(rs.getString("tenlop"));
                return clazz;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//    @Override
//    public Clazz findByName(String name) {
//        String sql = "SELECT * FROM lop WHERE tenlop = ?";
//        try(Connection connection= this.dataSource.getConnection();
//            PreparedStatement ps = connection.prepareStatement(sql)){
//            ps.setString(1, name);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()){
//                Clazz clazz = new Clazz();
//                clazz.setId(rs.getString("malop"));
//                clazz.setName(rs.getString("tenlop"));
//                return clazz;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    @Override
    public boolean add(Clazz clazz) {
        String sql = "INSERT INTO lop (malop, tenlop) VALUES (?, ?)";
        try (Connection connection = this.dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, clazz.getId());
            ps.setString(2, clazz.getName());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Clazz clazz) {
        String sql = "UPDATE lop SET tenlop = ? WHERE malop = ?";
        try (Connection connection = this.dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, clazz.getName());
            ps.setString(2, clazz.getId());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        String sql = "DELETE FROM lop WHERE malop = ?";
        try (Connection connection = this.dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}