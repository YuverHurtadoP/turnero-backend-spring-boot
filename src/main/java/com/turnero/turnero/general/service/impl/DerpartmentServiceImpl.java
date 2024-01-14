package com.turnero.turnero.general.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turnero.turnero.general.dao.IDepartmentDao;
import com.turnero.turnero.general.dto.response.DepartmentResponseDto;
import com.turnero.turnero.general.entity.DepartmentEntity;
import com.turnero.turnero.general.service.IDerpartmentService;
@Service
public class DerpartmentServiceImpl implements IDerpartmentService{
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private IDepartmentDao departmentDao;
	
	

	@Override
	public List<DepartmentResponseDto> departmentList() {
		 List<DepartmentEntity> departmentListEntity = departmentDao.findAll();
		return departmentListEntity.stream().map(departmentInfo -> modelMapper.map(departmentInfo, DepartmentResponseDto.class))
	            .collect(Collectors.toList());
	}



	@Override
	public DepartmentResponseDto findByDeparmentId(int deparmentId) {
		Optional<DepartmentEntity> departmentEntity = departmentDao.findByDeparmentId(deparmentId);
		if(departmentEntity.isPresent())
			return modelMapper.map(departmentEntity, DepartmentResponseDto.class);
		return null;
	}

}
