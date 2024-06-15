package com.vj.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vj.demo.entity.Employee;
import com.vj.demo.exception.EmployeeException;
import com.vj.demo.request.EmployeeRequest;
import com.vj.demo.request.EmployeeResponse;
import com.vj.demo.request.EmployeeSearch;
import com.vj.demo.service.EmployeeService;


@RestController
@RequestMapping("api/v1/employee/")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("save")
	public ResponseEntity<String> saveEmployee(@RequestBody EmployeeRequest employeeRequest) {
		try {
			Employee employee = employeeService.saveEmployee(employeeRequest);
			if (employee != null) {
				return new ResponseEntity<>("Employee Added...", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}catch(EmployeeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch(Exception e) {
			return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("get/{id}")
	public Employee getEmployeeById(@PathVariable Long id) {
		return employeeService.getEmployee(id);
	}
	
	@PostMapping("search/all")
	public EmployeeResponse findAllEmployee(@RequestBody EmployeeSearch search) {
		return employeeService.findAllEmployee(search);
	}
}
