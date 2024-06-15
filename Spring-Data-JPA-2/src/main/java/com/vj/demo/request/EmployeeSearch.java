package com.vj.demo.request;

public class EmployeeSearch {
	
	private String employeeName;
	private Long salary;
	private String companyName;
	private String dept;
	private Long age;
	private String address;
	private int limit;
	private int page;
	private String orderBy;
	private String orderDirection;
	private int DEFAULT_SIZE = 5;
	private String DEFAULT_ORDER = "companyName";
	private String DEFAULT_DIRECTION = "asc";
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Long getSalary() {
		return salary;
	}
	public void setSalary(Long salary) {
		this.salary = salary;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public Long getAge() {
		return age;
	}
	public void setAge(Long age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getLimit() {
		if(limit == 0) {
			limit = DEFAULT_SIZE;
		}
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getOrderBy() {
		if(orderBy ==null || orderBy.isEmpty()) {
			orderBy = DEFAULT_ORDER;
		}
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public String getOrderDirection() {
		if(orderDirection == null || orderDirection.isEmpty()) {
			orderDirection = DEFAULT_DIRECTION;
		}
		return orderDirection;
	}
	public void setOrderDirection(String orderDirection) {
		this.orderDirection = orderDirection;
	}
	@Override
	public String toString() {
		return "EmployeeSearch [employeeName=" + employeeName + ", salary=" + salary + ", companyName=" + companyName
				+ ", dept=" + dept + ", age=" + age + ", address=" + address + ", limit=" + limit + ", page=" + page
				+ ", orderBy=" + orderBy + ", orderDirection=" + orderDirection + ", DEFAULT_SIZE=" + DEFAULT_SIZE
				+ ", DEFAULT_ORDER=" + DEFAULT_ORDER + ", DEFAULT_DIRECTION=" + DEFAULT_DIRECTION + "]";
	}

}
