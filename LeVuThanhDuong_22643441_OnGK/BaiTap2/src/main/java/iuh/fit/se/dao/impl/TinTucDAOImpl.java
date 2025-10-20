package iuh.fit.se.dao.impl;

import iuh.fit.se.dao.DanhMucDAO;
import iuh.fit.se.dao.TinTucDAO;
import iuh.fit.se.model.DanhMuc;
import iuh.fit.se.model.TinTuc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TinTucDAOImpl implements TinTucDAO {

    private DataSource dataSource;

    public TinTucDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<TinTuc> findAll() {
        List<TinTuc> list = new ArrayList<TinTuc>();
        String sql = "SELECT * FROM TinTuc";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs =  ps.executeQuery()){

            while (rs.next()){
                TinTuc tinTuc = new TinTuc();
                tinTuc.setMaTinTuc(rs.getInt("MATT"));
                tinTuc.setTieuDe(rs.getString("TieuDe"));
                tinTuc.setNoiDung(rs.getString("NoiDungTT"));
                tinTuc.setLienKet(rs.getString("LienKetTT"));
                int maDanhMuc = rs.getInt("MADM");
                DanhMucDAO danhMucDAO = new DanhMucDAOImpl(dataSource);
                DanhMuc danhMuc = danhMucDAO.findById(maDanhMuc);
                tinTuc.setDanhMuc(danhMuc);
                list.add(tinTuc);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<TinTuc> findByDanhMuc(int maDanhMuc) {
        List<TinTuc> list = new ArrayList<TinTuc>();
        String sql = "SELECT * FROM TinTuc WHERE MADM = ?";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1, maDanhMuc);
            ResultSet rs =  ps.executeQuery();
            while (rs.next()){
                TinTuc tinTuc = new TinTuc();
                tinTuc.setMaTinTuc(rs.getInt("MATT"));
                tinTuc.setTieuDe(rs.getString("TieuDe"));
                tinTuc.setNoiDung(rs.getString("NoiDungTT"));
                tinTuc.setLienKet(rs.getString("LienKetTT"));
                DanhMucDAO danhMucDAO = new DanhMucDAOImpl(dataSource);
                DanhMuc danhMuc = danhMucDAO.findById(maDanhMuc);
                tinTuc.setDanhMuc(danhMuc);
                list.add(tinTuc);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public TinTuc findById(int maTinTuc) {
        String sql = "SELECT * FROM TinTuc WHERE MATT = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, maTinTuc);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                TinTuc tinTuc = new TinTuc();
                tinTuc.setMaTinTuc(rs.getInt("MATT"));
                tinTuc.setTieuDe(rs.getString("TieuDe"));
                tinTuc.setNoiDung(rs.getString("NoiDungTT"));
                tinTuc.setLienKet(rs.getString("LienKetTT"));
                int maDM = rs.getInt("MADM");
                DanhMucDAO danhMucDAO = new DanhMucDAOImpl(dataSource);
                tinTuc.setDanhMuc(danhMucDAO.findById(maDM));
                return tinTuc;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean save(TinTuc tinTuc) {
        String sql = "INSERT INTO TinTuc (TieuDe, NoiDungTT, LienKetTT, MADM) VALUES (?, ?, ?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, tinTuc.getTieuDe());
            ps.setString(2, tinTuc.getNoiDung());
            ps.setString(3, tinTuc.getLienKet());
            ps.setInt(4, tinTuc.getDanhMuc().getMaDanhMuc());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int maTinTuc) {
        String sql = "DELETE FROM TinTuc WHERE MATT = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, maTinTuc);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
