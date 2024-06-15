package com.vj.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vj.demo.entity.Employee;
import com.vj.demo.service.ReadFileService;


@RestController
@RequestMapping("api/v1/file/")
public class ReadFileController {
	
	@Autowired
	private ReadFileService readFileService;
	
	@PostMapping(value = "read",  consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.MULTIPART_MIXED_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE,
			MediaType.APPLICATION_OCTET_STREAM_VALUE })
	public ResponseEntity<String> readFile(@RequestPart MultipartFile multipartFile)
			throws IOException {
		ResponseEntity<String> response= null;
		List<Employee> list = readFileService.readFile(multipartFile);
		if(list != null) {
			response = new ResponseEntity<>("Record Inserted ...", HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return response;
	}

}
