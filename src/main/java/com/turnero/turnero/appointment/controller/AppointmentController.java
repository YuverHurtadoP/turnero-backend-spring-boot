package com.turnero.turnero.appointment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.turnero.turnero.appointment.dto.request.AcceptAppointmentRequestDto;
import com.turnero.turnero.appointment.dto.request.AppointmentRequestDto;
import com.turnero.turnero.appointment.dto.response.AppointmentDetailResponseDto;
import com.turnero.turnero.appointment.dto.response.AppointmentResponseDto;
import com.turnero.turnero.appointment.service.IAppointmentService;
import com.turnero.turnero.general.dto.response.MunicipalityResponseDto;

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
 
	
	@PostMapping("acceptappointment")
	public ResponseEntity<String> acceptAppoinment(@Valid @RequestBody AcceptAppointmentRequestDto dto) {
		return new ResponseEntity<>(appointmentService.acceptAppointment(dto),HttpStatus.CREATED);
	}
	
	@PostMapping("update-appointment")
	public ResponseEntity<String> updateAppoinment(
			@RequestParam(name = "status", required = true) Integer statusAppointment,
			@RequestParam(name = "status", required = true) Integer appointmentId
			) {
		return new ResponseEntity<>(appointmentService.changeStatusAppointment(statusAppointment,appointmentId),HttpStatus.CREATED);
	}
	
	@GetMapping("/list_patient/{nro_dni}")
	public ResponseEntity<List<AppointmentDetailResponseDto>> getAppointmentByPatientId(@PathVariable("nro_dni") String  nroDni) {
		List<AppointmentDetailResponseDto> response =  appointmentService.findByPatientId(nroDni);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/list_medical/{nro_dni}")
	public ResponseEntity<List<AppointmentDetailResponseDto>> getAppointmentByMedicoId(@PathVariable("nro_dni") String  nroDni) {
		List<AppointmentDetailResponseDto> response =  appointmentService.findByPersonalMedicoId(nroDni);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
