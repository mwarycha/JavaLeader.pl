package pl.javaleader.discriminatorcolumn.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.javaleader.discriminatorcolumn.model.Monitor;

import org.springframework.stereotype.Repository;

@Repository
public interface MonitorRepository extends CrudRepository<Monitor, Long> {
}
