package edu.mum.scrum.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.scrum.domain.Employee;
import edu.mum.scrum.repository.EmployeeRepository;
import edu.mum.scrum.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

}
