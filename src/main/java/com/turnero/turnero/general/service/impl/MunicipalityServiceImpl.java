package com.turnero.turnero.general.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turnero.turnero.general.dao.IMunicipalityDao;
import com.turnero.turnero.general.dto.response.MunicipalityResponseDto;
import com.turnero.turnero.general.entity.MunicipalityEntity;
import com.turnero.turnero.general.service.IMunicipalityService;

@Service
public class MunicipalityServiceImpl implements IMunicipalityService {
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private IMunicipalityDao municipalityDao;
	@Override
	public List<MunicipalityResponseDto> municipalityList() {
		List<MunicipalityEntity> municipalityListEntity = municipalityDao.findAll(); 
		 return  municipalityListEntity.stream().map(info -> modelMapper.map(info, MunicipalityResponseDto.class))
		            .collect(Collectors.toList());
	}
	@Override
	public MunicipalityResponseDto findByMunicipalityId(int municipalityId) {
		Optional<MunicipalityEntity> municipality = municipalityDao.findByMunicipalityId(municipalityId);
		if(municipality.isPresent())
			return modelMapper.map(municipality, MunicipalityResponseDto.class);
		return null;
	}

}
