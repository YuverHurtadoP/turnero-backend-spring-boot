package com.turnero.turnero.access.Service.impl;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turnero.turnero.access.Service.IRolService;
import com.turnero.turnero.access.Service.IUserService;
import com.turnero.turnero.access.dao.IRolDao;
import com.turnero.turnero.access.dao.IUserDao;
import com.turnero.turnero.access.dto.Response.UserResponseDto;
import com.turnero.turnero.access.dto.request.UserRequestDto;
import com.turnero.turnero.access.entity.UserEntity;
import com.turnero.turnero.exception.ErrorInternalServer;
import com.turnero.turnero.exception.NotFoundException;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserDao userDao;
	
	@Autowired
	private IRolDao rolDao;
	
	@Autowired
	private IRolService  rolService;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserResponseDto saveUser(UserRequestDto dto) {
		UserEntity entityUser = new UserEntity();
		if(rolService.findByrolId(dto.getRolUser()) != null)
			throw new  NotFoundException("No se encuetra el rol en la base de datos");
		if(userDao.findByEmail(dto.getEmail()).isPresent())
			throw new  ErrorInternalServer("El usuario : "+dto.getEmail() +" ya esta presente en la base de dato");
		dto.setActive(true);
		dto.setUpdatedAp(null);
		dto.setCreatedAp(new Date());
		entityUser = modelMapper.map(dto, UserEntity.class);
		entityUser = userDao.save(entityUser);
		return modelMapper.map(entityUser,UserResponseDto.class);
	}

}
