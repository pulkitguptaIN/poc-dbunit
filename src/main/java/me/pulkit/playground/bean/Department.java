package me.pulkit.playground.bean;

import java.io.Serializable;

public class Department implements Serializable {

	private static final long serialVersionUID = 5781151553351459141L;

	private Integer departmentId;
	private String departmentName;

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Department [departmentId=");
		builder.append(departmentId);
		builder.append(", departmentName=");
		builder.append(departmentName);
		builder.append("]");
		return builder.toString();
	}

}
