package iuh.fit.se.dao;

import iuh.fit.se.model.Clazz;

import java.util.List;

public interface ClazzDAO {
    List<Clazz> findAll();
    Clazz findById(String id);
    boolean add(Clazz clazz);
    boolean update(Clazz clazz);
    boolean delete(String id);
}
