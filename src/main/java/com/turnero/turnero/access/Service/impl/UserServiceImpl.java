package com.turnero.turnero.access.Service.impl;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.turnero.turnero.access.Service.IRolService;
import com.turnero.turnero.access.Service.IUserService;
import com.turnero.turnero.access.dao.IRolDao;
import com.turnero.turnero.access.dao.IUserDao;
import com.turnero.turnero.access.dto.Response.TokenResponseDto;
import com.turnero.turnero.access.dto.Response.UserResponseDto;
import com.turnero.turnero.access.dto.request.LoginRequestDto;
import com.turnero.turnero.access.dto.request.UserRequestDto;
import com.turnero.turnero.access.entity.UserEntity;
import com.turnero.turnero.access.jwt.JwtService;
import com.turnero.turnero.exception.BadRequestException;
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
	
	@Autowired
	private  PasswordEncoder passwordEncoder;
	
	@Autowired
	private  AuthenticationManager authenticationManager;
	
	@Autowired
	private  JwtService jwtService;

	@Override
	public UserResponseDto saveUser(UserRequestDto dto) {
		UserEntity entityUser = new UserEntity();
		if(!dto.getPassword().equals(dto.getPasswordConfirm()))
			throw new  BadRequestException("Las contraseñas no coinciden");
		if(rolService.findByrolId(dto.getRolUser()) == null)
			throw new NotFoundException("No se encuetra el rol en la base de datos:"+dto.getRolUser());
		if(userDao.findByEmail(dto.getEmail()).isPresent())
			throw new  NotFoundException("El usuario : "+dto.getEmail() +" ya esta presente en la base de dato");
		dto.setActive(true);
		dto.setUpdatedAp(null);
		dto.setCreatedAp(new Date());
		String pass = passwordEncoder.encode(dto.getPassword());
		dto.setPassword(pass);
		entityUser = modelMapper.map(dto, UserEntity.class);
		entityUser.setUserId(0);
		entityUser = userDao.save(entityUser);
		return modelMapper.map(entityUser,UserResponseDto.class);
	}

	@Override
	public TokenResponseDto login(LoginRequestDto loginDto) {
		  authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
	        UserDetails user=userDao.findByEmail(loginDto.getUsername()).orElseThrow();
	        String token=jwtService.getToken(user);
	        return TokenResponseDto.builder()
	            .token(token)
	            .build();
	}

}
