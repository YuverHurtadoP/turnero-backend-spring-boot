package com.turnero.turnero.person.service.impl;

import java.util.Date;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turnero.turnero.access.Service.IUserService;
import com.turnero.turnero.access.dto.request.UserRequestDto;
import com.turnero.turnero.exception.ErrorInternalServer;
import com.turnero.turnero.exception.NotFoundException;
import com.turnero.turnero.general.service.IDocumentTypeService;
import com.turnero.turnero.general.service.IMunicipalityService;
import com.turnero.turnero.person.dao.IPersonDao;
import com.turnero.turnero.person.dto.request.PersonRequestDto;
import com.turnero.turnero.person.dto.response.PersonResponseDto;
import com.turnero.turnero.person.entity.PersonEntity;
import com.turnero.turnero.person.service.IPersonService;

import jakarta.transaction.Transactional;
@Service
public class PersonServiceImpl implements IPersonService {
	
	private static final Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);

	@Autowired
	private IPersonDao personDao;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private IMunicipalityService municipalityService;

	@Autowired
	private IDocumentTypeService documentTypeService;
	
	@Autowired
	private IUserService userService;

	@Override
	@Transactional
	public PersonResponseDto savePerson(PersonRequestDto dto) {
		PersonEntity entntyPerson = new PersonEntity();
	 
			Optional<PersonEntity> personEntity = personDao.findByNroDni(dto.getNroDni());
		if(personEntity.isPresent())
			throw new  ErrorInternalServer("El usuario con DNI: "+dto.getNroDni() +" ya esta presente en la base de dato");
		
		if(municipalityService.findByMunicipalityId(dto.getMunicipalityId()) == null)
			throw new  NotFoundException("No se encuentra el municipio en la base de datos");
		
		if(documentTypeService.findByDocumentTypeId(dto.getDocumentTypeId()) == null)
			throw new  NotFoundException("No se encuentra el tipo de docuemnto  en la base de datos");
		entntyPerson  = modelMapper.map(dto, PersonEntity.class);
		entntyPerson.setActive(true);
		entntyPerson.setUpdatedAp(null);
		entntyPerson.setCreatedAp(new Date());
		UserRequestDto userDto = new UserRequestDto();
		userDto = dto.getUserRequestDto();
		System.out.println(dto.i);
		entntyPerson = personDao.save(entntyPerson);
		
		
		userDto.setPersonId(entntyPerson.getPersonId());
		System.out.println(userDto.getEmail());
		//userService.saveUser(userDto);

		return modelMapper.map(entntyPerson,PersonResponseDto.class);
	}

}
