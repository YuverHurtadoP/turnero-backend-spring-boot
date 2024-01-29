package com.turnero.turnero.access.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turnero.turnero.access.Service.IUserService;
import com.turnero.turnero.access.dto.Response.TokenResponseDto;
import com.turnero.turnero.access.dto.request.LoginRequestDto;
import com.turnero.turnero.access.dto.request.RecoveryPasswordRequestDto;
import com.turnero.turnero.exception.dto.Message;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = {"*"})
public class UserController {
	@Autowired
	private IUserService userService;
	
	@PostMapping
	public ResponseEntity<TokenResponseDto> login(@Valid @RequestBody LoginRequestDto dto) {
		return new ResponseEntity<>(userService.login(dto),HttpStatus.CREATED);
	}
	
	@PostMapping("/recovery")
	public ResponseEntity<Message> RecoveryPassword(@Valid @RequestBody RecoveryPasswordRequestDto dto) {
		return new ResponseEntity<>(userService.recoveryPassword(dto),HttpStatus.CREATED);
	}
	
	

}
