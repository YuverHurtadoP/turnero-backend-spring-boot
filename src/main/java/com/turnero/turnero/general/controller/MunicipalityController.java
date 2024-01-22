package com.turnero.turnero.general.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turnero.turnero.general.dto.response.MunicipalityResponseDto;
import com.turnero.turnero.general.service.IMunicipalityService;
@RestController
@RequestMapping("/api/municipality")
public class MunicipalityController {
	
	@Autowired
	private IMunicipalityService municipalityService;
	
	@GetMapping("/list/{department_id}")
	public ResponseEntity<List<MunicipalityResponseDto>> getMunicipalityList(@PathVariable("department_id") Integer departmentId) {
		List<MunicipalityResponseDto> response =  municipalityService.municipalityList(departmentId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
