package iuh.fit.se.service.impl;

import iuh.fit.se.model.TableStatus;
import iuh.fit.se.repository.TableStatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableStatusServiceImpl implements iuh.fit.se.service.TableStatusService {
    TableStatusRepository tableStatusRepository;

    public TableStatusServiceImpl(TableStatusRepository tableStatusRepository) {
        this.tableStatusRepository = tableStatusRepository;
    }

    @Override
    public List<TableStatus> findAll(){
        return tableStatusRepository.findAll();
    }
    @Override
    public TableStatus findById(Long id){
        return tableStatusRepository.findById(id).orElse(null);
    }

}
