package com.turnero.turnero.person.service;

import com.turnero.turnero.person.dto.request.PersonRequestDto;
import com.turnero.turnero.person.dto.request.PersonUpdateRequestDto;
import com.turnero.turnero.person.dto.response.PersonResponseDto;

public interface IPersonService {
	public PersonResponseDto savePerson( PersonRequestDto dto);
	public PersonResponseDto updatePerson(PersonUpdateRequestDto dto);
	
	public PersonResponseDto findByPersonId(Integer personId);
}
