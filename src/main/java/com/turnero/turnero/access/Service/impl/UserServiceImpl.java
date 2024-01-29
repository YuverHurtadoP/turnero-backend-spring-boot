package com.turnero.turnero.access.Service.impl;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

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
import com.turnero.turnero.access.dto.request.RecoveryPasswordRequestDto;
import com.turnero.turnero.access.dto.request.UserRequestDto;
import com.turnero.turnero.access.entity.UserEntity;
import com.turnero.turnero.access.jwt.JwtService;
import com.turnero.turnero.exception.BadRequestException;
import com.turnero.turnero.exception.ErrorInternalServer;
import com.turnero.turnero.exception.NotFoundException;
import com.turnero.turnero.exception.dto.Message;
import com.turnero.turnero.general.dto.request.EmailRequestDto;
import com.turnero.turnero.general.service.impl.EmailServiceImpl;
import com.turnero.turnero.person.dao.IPersonDao;
import com.turnero.turnero.person.entity.PersonEntity;

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
	
	@Autowired
	private EmailServiceImpl emailServiceImpl;
	
	@Autowired
	private IPersonDao personDao;
	

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

	@Override
	public  Message recoveryPassword(RecoveryPasswordRequestDto dto) {
		 Optional<UserEntity> entity =  userDao.findByEmail(dto.getEmail());
		 
		 
		 
		 if(entity.isPresent()  ) {
			 
			 Optional<PersonEntity> entityPerson  = personDao.findByPersonId(entity.get().getPersonId());
			 if(entityPerson.isPresent() && entityPerson.get().getNroDni() == dto.getDni()) {
				 String pass = this.generateRandomString(5);
				 EmailRequestDto email = new EmailRequestDto();
				 
				 
					email.setMailTo(dto.getEmail());
					email.setSubject("Recuperación de acceso");
					email.setBody("La siguiente es su clave de acceso: "+pass);
					 
				 userDao.recoveryPassword(passwordEncoder.encode(pass), new Date(), dto.getEmail());
				 emailServiceImpl.sendEmail(email);
				 return new Message("A su correo electrónico le hemos enviado la nueva contraseña");
			 }else{
				 throw new  NotFoundException("El número de documento no está asociado al correo electrónico");
			 }
			
		 }else {
			  throw new  NotFoundException("El usuario no esta presente en la base de dato");
		 }
 	}
	
	private   String generateRandomString(int longitud) {
        String randomString = UUID.randomUUID().toString().replaceAll("-", "");
        return  randomString.substring(0, longitud);
    }

}
