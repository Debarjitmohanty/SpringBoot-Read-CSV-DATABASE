package com.vj.demo.request;

import java.util.List;

import com.vj.demo.entity.Employee;

public class EmployeeResponse {
	
	private long count;
	private List<Employee> employees;
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	@Override
	public String toString() {
		return "EmployeeResponse [count=" + count + ", employees=" + employees + "]";
	}
}
