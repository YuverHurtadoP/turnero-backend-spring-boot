package com.turnero.turnero.appointment.service;

import com.turnero.turnero.appointment.dto.request.AppointmentRequestDto;
import com.turnero.turnero.appointment.dto.response.AppointmentResponseDto;

public interface IAppointmentService {
	
	public AppointmentResponseDto save(AppointmentRequestDto dto);
}
