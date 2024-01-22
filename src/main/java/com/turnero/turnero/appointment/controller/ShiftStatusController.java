package com.turnero.turnero.appointment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turnero.turnero.appointment.dto.response.ShiftStatusResponseDto;
import com.turnero.turnero.appointment.service.IShiftStatusService;

@RestController
@RequestMapping("/api/shift_status")
public class ShiftStatusController {
	@Autowired
	private IShiftStatusService shiftStatusService;
	
	@GetMapping("/list")
	public ResponseEntity<List<ShiftStatusResponseDto>> getShiftList() {
		List<ShiftStatusResponseDto > response = shiftStatusService.shiftStatusList();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
