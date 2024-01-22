package com.turnero.turnero.appointment.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turnero.turnero.appointment.dao.IShiftStatusDao;
import com.turnero.turnero.appointment.dto.response.ShiftStatusResponseDto;
import com.turnero.turnero.appointment.entity.ShiftStatusEntity;
import com.turnero.turnero.appointment.service.IShiftStatusService;

@Service
public class ShiftStatusServiceImpl implements IShiftStatusService {
	
	@Autowired
	private IShiftStatusDao  shiftStatusDao;
	
	@Autowired
	private ModelMapper modelMapper;
	

	@Override
	public List<ShiftStatusResponseDto> shiftStatusList() {
		List<ShiftStatusEntity> entityList = shiftStatusDao.findAll();
		return  entityList.stream().map(info -> modelMapper.map(info, ShiftStatusResponseDto.class))
	            .collect(Collectors.toList());
	}

}
