package com.vj.demo.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vj.demo.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	@Query(value = "SELECT e  from Employee e ", nativeQuery = false)
	Page<Employee> findAllEmployee(Pageable pageable);
	
	@Query(value = "SELECT e  from Employee e where  e.employeeName =?1 "
			+ " OR e.companyName =?2 OR e.salary =?3 ", nativeQuery = false)
	Page<Employee> findAllEmployeeBySearch(Pageable pageable, String employeeName, 
			String companyName, Long salary);
	
}
