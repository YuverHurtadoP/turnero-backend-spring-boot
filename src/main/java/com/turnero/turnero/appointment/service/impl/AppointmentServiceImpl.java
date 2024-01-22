package com.turnero.turnero.appointment.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turnero.turnero.appointment.dao.IAppointmentDao;
import com.turnero.turnero.appointment.dto.request.AppointmentRequestDto;
import com.turnero.turnero.appointment.dto.response.AppointmentResponseDto;
import com.turnero.turnero.appointment.entity.AppointmentRequestEntity;
import com.turnero.turnero.appointment.service.IAppointmentService;

@Service
public class AppointmentServiceImpl implements IAppointmentService{
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private IAppointmentDao appointmentDao;

	@Override
	public AppointmentResponseDto save(AppointmentRequestDto dto) {
		AppointmentRequestEntity entity = modelMapper.map(dto, AppointmentRequestEntity.class);
		entity.setAppointmentId(0);
		entity = appointmentDao.save(entity);
		return modelMapper.map(entity,AppointmentResponseDto.class);
	}

}
