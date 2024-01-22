package com.turnero.turnero.appointment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turnero.turnero.appointment.dto.response.ShiftClassificationResponseDto;
import com.turnero.turnero.appointment.service.IShiftClassificationService;
@RestController
@RequestMapping("/api/shift")
public class ShiftClassificationController {
	
	@Autowired
	private IShiftClassificationService shiftClassificationService;
	
	@GetMapping("/list")
	public ResponseEntity<List<ShiftClassificationResponseDto>> getShiftList() {
		List<ShiftClassificationResponseDto> response = shiftClassificationService.shiftClassificationList();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
