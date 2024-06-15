package com.vj.demo.service;

import com.vj.demo.entity.Employee;
import com.vj.demo.request.EmployeeRequest;
import com.vj.demo.request.EmployeeResponse;
import com.vj.demo.request.EmployeeSearch;

public interface EmployeeService {

	public Employee saveEmployee(EmployeeRequest employeeRequest);
	
	public Employee getEmployee(Long id);

	public EmployeeResponse findAllEmployee(EmployeeSearch search);
}
