package com.turnero.turnero.appointment.service;

import java.util.List;

import com.turnero.turnero.appointment.dto.response.ShiftStatusResponseDto;

public interface IShiftStatusService {
 List<ShiftStatusResponseDto> shiftStatusList();
}
