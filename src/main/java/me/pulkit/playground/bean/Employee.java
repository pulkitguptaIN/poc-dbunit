package me.pulkit.playground.bean;

import java.io.Serializable;

public class Employee implements Serializable {

	private static final long serialVersionUID = -3213390222743461543L;

	private Integer employeeId;
	private String employeeName;
	private Department department;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [employeeId=");
		builder.append(employeeId);
		builder.append(", employeeName=");
		builder.append(employeeName);
		builder.append(", department=");
		builder.append(department);
		builder.append("]");
		return builder.toString();
	}

}
