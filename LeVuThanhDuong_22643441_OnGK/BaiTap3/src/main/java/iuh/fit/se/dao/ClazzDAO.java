package iuh.fit.se.dao;

import iuh.fit.se.model.Clazz;

import java.util.List;

public interface ClazzDAO {
    List<Clazz> findAll();
    Clazz findById(String id);
    Clazz findByName(String name);
    boolean add(Clazz clazz);
    boolean update(Clazz clazz);
    boolean delete(Clazz clazz);
}
