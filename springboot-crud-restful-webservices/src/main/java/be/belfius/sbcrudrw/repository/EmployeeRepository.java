package be.belfius.sbcrudrw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import be.belfius.sbcrudrw.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
