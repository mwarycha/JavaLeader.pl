package pl.javaleader.SpEL.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.javaleader.SpEL.model.Employee;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.javaleader.SpEL.model.Role;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

  @Query("SELECT e FROM #{#entityName} e WHERE e.name = ?1")
  List<Employee> findByName(String name);

  @Query("SELECT e FROM #{#entityName} e WHERE " +
          "(:#{#role} is NULL OR e.role =:#{#role})" +
          "AND" +
          "(:#{#name} is NULL OR e.name =:#{#name}) " +
          "AND " +
          "(:#{#surname} is NULL OR e.surname =:#{#surname})" +
          "AND" +
          "(:#{#salary} is NULL OR e.salary >=:#{#salary})"
  )

  List<Employee> findEmployeeByCriteria(
          Role role,
          String name,
          String surname,
          int salary
  );
}