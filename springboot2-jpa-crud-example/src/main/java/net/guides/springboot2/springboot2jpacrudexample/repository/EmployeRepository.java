package net.guides.springboot2.springboot2jpacrudexample.repository;

import net.guides.springboot2.springboot2jpacrudexample.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeRepository extends CrudRepository<Employee, Long>{
}
