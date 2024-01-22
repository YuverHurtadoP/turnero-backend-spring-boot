package com.turnero.turnero.appointment.service;

import java.util.List;

import com.turnero.turnero.appointment.dto.response.ShiftClassificationResponseDto;

public interface IShiftClassificationService {
	
	public List<ShiftClassificationResponseDto> shiftClassificationList();

}
