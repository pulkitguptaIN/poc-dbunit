package me.pulkit.playground.service;

import org.springframework.transaction.annotation.Transactional;

import me.pulkit.playground.bean.Employee;

public interface EmployeeService {

	@Transactional
	void create(Employee employee);

	Employee read(Integer employeeId);

	@Transactional
	Integer update(Employee employee);

	@Transactional
	Integer delete(Integer employeeId);
}
