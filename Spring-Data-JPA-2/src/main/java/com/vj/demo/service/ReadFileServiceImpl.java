package com.vj.demo.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vj.demo.entity.Employee;
import com.vj.demo.repo.EmployeeRepository;

@Service
public class ReadFileServiceImpl implements ReadFileService{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> readFile(MultipartFile file) throws IOException {
		List<Employee> list = new ArrayList<>();
		InputStream is = file.getInputStream();
		BufferedReader fileReader = new BufferedReader(new InputStreamReader(is,"UTF-8"));		
		
		CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT);
		Iterable<CSVRecord> iterable = csvParser.getRecords();
		int i = 1;
		for(CSVRecord csvRecord: iterable) {
			if(i == 1) {
				i++;
				continue;
			}
			Employee employee = new Employee();
			employee.setDept(csvRecord.get(0));
			employee.setSalary(Long.parseLong(csvRecord.get(1)));
			employee.setAddress(csvRecord.get(2));
			employee.setAge(Long.parseLong(csvRecord.get(3)));
			employee.setCompanyName(csvRecord.get(4));
			list.add(employee);
		}
		if(list != null) {
			list = employeeRepository.saveAll(list);
		}
		return list;
	}

}
