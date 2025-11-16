package iuh.fit.se.service;

import iuh.fit.se.model.TableStatus;

import java.util.List;

public interface TableStatusService {
    TableStatus findById(Long id);
    List<TableStatus> findAll();
}
