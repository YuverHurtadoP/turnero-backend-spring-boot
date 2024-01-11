package com.turnero.turnero.access.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turnero.turnero.access.Service.IRolService;
import com.turnero.turnero.access.dto.Response.RolResponseDto;

@RestController
@RequestMapping("/api/rol")
public class RolController {
	
	@Autowired
	private IRolService rolService;
	
	@GetMapping("/list")
	public ResponseEntity<List<RolResponseDto>> getDepartmentList() {
		List<RolResponseDto> response = rolService.rolList();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}
