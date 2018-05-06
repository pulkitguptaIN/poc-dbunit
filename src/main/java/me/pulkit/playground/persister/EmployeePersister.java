package me.pulkit.playground.persister;

import me.pulkit.playground.bean.Employee;

public interface EmployeePersister {

	void create(Employee employee);

	Employee read(Integer employeeId);

	Integer update(Employee employee);

	Integer delete(Integer employeeId);
}
