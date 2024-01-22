package com.turnero.turnero.appointment.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turnero.turnero.appointment.dao.ShiftClassificationDao;
import com.turnero.turnero.appointment.dto.response.ShiftClassificationResponseDto;
import com.turnero.turnero.appointment.entity.ShiftClassificationEntity;
import com.turnero.turnero.appointment.service.IShiftClassificationService;

@Service
public class ShiftClassificationServiceImpl implements IShiftClassificationService {
	
	@Autowired
	private ShiftClassificationDao shiftClassificationDao;
	
	@Autowired
	private ModelMapper modelMapper;
	

	@Override
	public List<ShiftClassificationResponseDto> shiftClassificationList() {
		List<ShiftClassificationEntity> entityList =  shiftClassificationDao.findAll();
		return  entityList.stream().map(info -> modelMapper.map(info, ShiftClassificationResponseDto.class))
	            .collect(Collectors.toList());
	}

}
