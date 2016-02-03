package edu.mum.scrum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.scrum.domain.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	public List<Employee> findByRoles_RoleName(String roleName);
	public Employee findByEmployeeId(Long employeeId);
	public int deleteByEmployeeId(Long id);
	public Employee findByFirstname(String name);
	public Employee findByUsername(String username);

}

