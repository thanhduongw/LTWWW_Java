package iuh.fit.se.dao.impl;

import iuh.fit.se.dao.ClazzDAO;
import iuh.fit.se.dao.StudentDAO;
import iuh.fit.se.model.Clazz;
import iuh.fit.se.model.Student;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    private DataSource dataSource;
    private ClazzDAO clazzDAO;

    public StudentDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
        this.clazzDAO = new ClazzDAOImpl(dataSource);
    }

    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM sinhvien";
        try (Connection connection = this.dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getString("mssv"));
                student.setName(rs.getString("hoten"));
                student.setDob(rs.getDate("ngaysinh").toLocalDate());
                student.setScore(rs.getDouble("diem"));
                student.setClazz(clazzDAO.findById(rs.getString("malop")));
                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public Student findById(String id) {
        String sql = "SELECT * FROM sinhvien WHERE mssv = ?";
        try (Connection connection = this.dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Student student = new Student();
                student.setId(rs.getString("mssv"));
                student.setName(rs.getString("hoten"));
                student.setDob(rs.getDate("ngaysinh").toLocalDate());
                student.setScore(rs.getDouble("diem"));
                student.setClazz(clazzDAO.findById(rs.getString("malop")));
                return student;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Student> findByClassName(String className) {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM sinhvien s JOIN lop c ON s.malop = c.malop WHERE c.tenlop = ?";
        try (Connection connection = this.dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, className);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getString("mssv"));
                student.setName(rs.getString("hoten"));
                student.setDob(rs.getDate("ngaysinh").toLocalDate());
                student.setScore(rs.getDouble("diem"));
                student.setClazz(clazzDAO.findById(rs.getString("malop")));
                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    // ===================== PHẦN HOÀN THIỆN =====================

    @Override
    public boolean add(Student student) {
        String sql = "INSERT INTO sinhvien (mssv, hoten, ngaysinh, diem, malop) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = this.dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, student.getId());
            ps.setString(2, student.getName());
            ps.setDate(3, Date.valueOf(student.getDob()));
            ps.setDouble(4, student.getScore());
            ps.setString(5, student.getClazz().getId());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Student student) {
        String sql = "UPDATE sinhvien SET hoten = ?, ngaysinh = ?, diem = ?, malop = ? WHERE mssv = ?";
        try (Connection connection = this.dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, student.getName());
            ps.setDate(2, Date.valueOf(student.getDob()));
            ps.setDouble(3, student.getScore());
            ps.setString(4, student.getClazz().getId());
            ps.setString(5, student.getId());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        String sql = "DELETE FROM sinhvien WHERE mssv = ?";
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
