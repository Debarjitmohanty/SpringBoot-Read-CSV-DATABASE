package com.vj.demo.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.vj.demo.entity.Employee;
import com.vj.demo.exception.EmployeeException;
import com.vj.demo.repo.EmployeeRepository;
import com.vj.demo.request.EmployeeRequest;
import com.vj.demo.request.EmployeeResponse;
import com.vj.demo.request.EmployeeSearch;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(EmployeeRequest employeeRequest) {
		validateRequest(employeeRequest);
		Employee employee = new Employee();
		if(employeeRequest.getEmployeeId() != 0) {
			Optional<Employee> emp = employeeRepository.findById(employeeRequest.getEmployeeId());
			if(emp.isPresent()) {
				employee = emp.get();
			} else {
				employee = new Employee();
			}
		}
		BeanUtils.copyProperties(employeeRequest, employee);
		return employeeRepository.save(employee);
	}

	private void validateRequest(EmployeeRequest employeeRequest) {
		if(employeeRequest.getEmployeeName() == null
					|| employeeRequest.getEmployeeName().trim().isEmpty()) {
			throw new EmployeeException(400, "Please Provide Employee Name");
		}
	}

	@Override
	public Employee getEmployee(Long id) {
		Optional<Employee> emp = employeeRepository.findById(id);
		if(emp.isPresent()) {
			return emp.get();
		} else {
			new Employee();
		}
		return null;
	}

	@Override
	public EmployeeResponse findAllEmployee(EmployeeSearch search) {
		EmployeeResponse response = new EmployeeResponse();
		Pageable paging = PageRequest.of(search.getPage() - 1, search.getLimit(),
				Sort.by(Sort.Direction.fromString(search.getOrderDirection()), search.getOrderBy()));
		if(search.getEmployeeName().isEmpty()
			&& search.getAddress().isEmpty()
			&& search.getAge() == 0
			&& search.getCompanyName().isEmpty()
			&& search.getDept().isEmpty()
			&& search.getSalary() == 0) {
			
			Page<Employee> employeeList = employeeRepository.findAllEmployee(paging);
			response.setCount(employeeList.getTotalElements());
			response.setEmployees(employeeList.getContent());
		} else {
			Page<Employee> employeeList = employeeRepository.findAllEmployeeBySearch(paging,
					search.getEmployeeName(),search.getCompanyName(),search.getSalary());
			response.setCount(employeeList.getTotalElements());
			response.setEmployees(employeeList.getContent());
		}
		return response;
	}

}
