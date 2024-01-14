package com.turnero.turnero.general.service;

import java.util.List;

import com.turnero.turnero.general.dto.response.DepartmentResponseDto;
import com.turnero.turnero.general.entity.DepartmentEntity;

public interface IDerpartmentService {
	public List<DepartmentResponseDto> departmentList();
	DepartmentResponseDto findByDeparmentId(int deparmentId);
}
