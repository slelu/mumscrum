package edu.mum.scrum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.scrum.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
