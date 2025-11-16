package iuh.fit.se.repository;

import iuh.fit.se.model.TableStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableStatusRepository extends JpaRepository<TableStatus, Long> {
}
