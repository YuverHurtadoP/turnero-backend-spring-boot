package com.turnero.turnero.person.controller;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turnero.turnero.person.dto.request.PersonRequestDto;
import com.turnero.turnero.person.dto.response.PersonResponseDto;
import com.turnero.turnero.person.service.IPersonService;

@RestController
@RequestMapping("/api/person")
public class PersonController {
	
	@Autowired
	private IPersonService personService;
	
	@PostMapping
	public ResponseEntity<PersonResponseDto> create(@RequestBody PersonRequestDto dto) {
		return new ResponseEntity<>(personService.savePerson(dto),HttpStatus.CREATED);
	}
	

}
