package com.vj.demo.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vj.demo.entity.Employee;

@Service
public interface ReadFileService {

	public List<Employee> readFile(MultipartFile file) throws IOException;
}
