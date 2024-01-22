package com.turnero.turnero.appointment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turnero.turnero.appointment.dto.request.AppointmentRequestDto;
import com.turnero.turnero.appointment.dto.response.AppointmentResponseDto;
import com.turnero.turnero.appointment.service.IAppointmentService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {
	@Autowired
	private IAppointmentService appointmentService;
	
	@PostMapping
	public ResponseEntity<AppointmentResponseDto> create(@Valid @RequestBody AppointmentRequestDto dto) {
		return new ResponseEntity<>(appointmentService.save(dto),HttpStatus.CREATED);
	}
	

}
