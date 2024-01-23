package com.turnero.turnero.appointment.service;

import java.util.List;

import com.turnero.turnero.appointment.dto.request.AcceptAppointmentRequestDto;
import com.turnero.turnero.appointment.dto.request.AppointmentRequestDto;
import com.turnero.turnero.appointment.dto.response.AppointmentDetailResponseDto;
import com.turnero.turnero.appointment.dto.response.AppointmentResponseDto;

public interface IAppointmentService {
	
	public AppointmentResponseDto save(AppointmentRequestDto dto);
	
	public String acceptAppointment (AcceptAppointmentRequestDto dto);
	
	public String changeStatusAppointment(Integer statusAppointment, Integer appointmentId);
	
	public List<AppointmentDetailResponseDto> findByPatientId(String nroDni);
	public List<AppointmentDetailResponseDto> findByPersonalMedicoId(String nroDni);
}
