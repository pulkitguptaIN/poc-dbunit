package me.pulkit.playground.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import me.pulkit.playground.bean.Employee;
import me.pulkit.playground.persister.EmployeePersister;
import me.pulkit.playground.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeePersister employeePersister;

	@Override
	public void create(Employee employee) {
		employeePersister.create(employee);

	}

	@Override
	public Employee read(Integer employeeId) {
		return employeePersister.read(employeeId);
	}

	@Override
	public Integer update(Employee employee) {
		return employeePersister.update(employee);
	}

	@Override
	public Integer delete(Integer employeeId) {
		return employeePersister.delete(employeeId);
	}

}
