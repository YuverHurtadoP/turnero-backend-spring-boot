package com.turnero.turnero.access.Service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turnero.turnero.access.Service.IRolService;
import com.turnero.turnero.access.dao.IRolDao;
import com.turnero.turnero.access.dto.Response.RolResponseDto;
import com.turnero.turnero.access.entity.RolEntity;
import com.turnero.turnero.exception.BadRequestException;

@Service
public class RolServiceImpl implements IRolService {
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private IRolDao rolDao;

	@Override
	public List<RolResponseDto> rolList() {
		  
		 List<RolEntity> rolListEntity = rolDao.findAll();
		 /*if(rolListEntity.size()==0)
			 throw new  BadRequestException("lista de rol vacia");*/
		 return rolListEntity.stream().map(departmentInfo -> modelMapper.map(departmentInfo, RolResponseDto.class))
		            .collect(Collectors.toList());
	}

	@Override
	public  RolResponseDto findByrolId(int rolId) {
		Optional<RolEntity> rol = rolDao.findByrolId(rolId);
		if(rol.isPresent())
			return modelMapper.map(rol.get(), RolResponseDto.class);
		return null;
	}

}
