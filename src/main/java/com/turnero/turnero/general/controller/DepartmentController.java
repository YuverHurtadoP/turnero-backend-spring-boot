package com.turnero.turnero.general.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

 
import com.turnero.turnero.general.dto.response.DepartmentResponseDto;
import com.turnero.turnero.general.service.IDerpartmentService;

 
@RestController
@RequestMapping("/api/departmet")
public class DepartmentController {
	
	@Autowired
	private IDerpartmentService derpartmentService;
	
	@GetMapping("/list")
	public ResponseEntity<List<DepartmentResponseDto>> getDepartmentList() {
		List<DepartmentResponseDto> response = derpartmentService.departmentList();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
 

}
