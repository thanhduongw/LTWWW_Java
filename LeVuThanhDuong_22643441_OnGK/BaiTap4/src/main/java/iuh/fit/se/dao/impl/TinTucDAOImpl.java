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
    private DanhMucDAO danhMucDAO;

    public TinTucDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
        this.danhMucDAO = new DanhMucDAOImpl(dataSource);
    }

    @Override
    public List<TinTuc> findAll() {
        List<TinTuc> list = new ArrayList<TinTuc>();
        String sql = "SELECT * FROM TINTUC";
        try(Connection connection = this.dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                TinTuc tinTuc = new TinTuc();
                tinTuc.setMaTT(rs.getString("maTT"));
                tinTuc.setTieuDe(rs.getString("tieuDe"));
                tinTuc.setNoiDungTT(rs.getString("noiDungTT"));
                tinTuc.setLienKet(rs.getString("lienKet"));
                DanhMuc danhMuc = danhMucDAO.findById(rs.getString("maDM"));
                tinTuc.setDanhMuc(danhMuc);
                list.add(tinTuc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<TinTuc> findByDanhMuc(String maDM) {
        List<TinTuc> list = new ArrayList<TinTuc>();
        String sql = "SELECT * FROM TINTUC WHERE maDM = ?";
        try(Connection connection = this.dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, maDM);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TinTuc tinTuc = new TinTuc();
                tinTuc.setMaTT(rs.getString("maTT"));
                tinTuc.setTieuDe(rs.getString("tieuDe"));
                tinTuc.setNoiDungTT(rs.getString("noiDungTT"));
                tinTuc.setLienKet(rs.getString("lienKet"));
                DanhMuc danhMuc = danhMucDAO.findById(maDM);
                tinTuc.setDanhMuc(danhMuc);
                list.add(tinTuc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public TinTuc findById(String id) {
        String sql = "SELECT * FROM TINTUC WHERE maTT = ?";
        try(Connection connection = this.dataSource.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TinTuc tinTuc = new TinTuc();
                tinTuc.setMaTT(rs.getString("maTT"));
                tinTuc.setTieuDe(rs.getString("tieuDe"));
                tinTuc.setNoiDungTT(rs.getString("noiDungTT"));
                tinTuc.setLienKet(rs.getString("lienKet"));
                DanhMuc danhMuc = danhMucDAO.findById(rs.getString("maDM"));
                tinTuc.setDanhMuc(danhMuc);
                return tinTuc;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean save(TinTuc tinTuc) {
        String sql = "INSERT INTO TINTUC(MATT, TIEUDE, NOIDUNGTT, LIENKET, MADM) VALUES(?, ?, ?, ?, ?)";
        try(Connection connection = this.dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, tinTuc.getMaTT());
            ps.setString(2, tinTuc.getTieuDe());
            ps.setString(3, tinTuc.getNoiDungTT());
            ps.setString(4, tinTuc.getLienKet());
            ps.setString(5, tinTuc.getDanhMuc().getMaDM());
            return ps.executeUpdate() > 0;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        String sql = "DELETE FROM TINTUC WHERE maTT = ?";
        try(Connection connection = this.dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
