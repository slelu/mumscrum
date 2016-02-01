package edu.mum.scrum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.scrum.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	public List<Employee> findByRoles_RoleName(String roleName);
	public Employee findByEmployeeId(Long employeeId);
	public Employee findByUsername(String username);

}
