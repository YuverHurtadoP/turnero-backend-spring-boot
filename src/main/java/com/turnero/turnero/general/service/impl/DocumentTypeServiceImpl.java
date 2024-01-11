package com.turnero.turnero.general.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turnero.turnero.general.dao.IDocumentTypeDao;
import com.turnero.turnero.general.dto.response.DocumentTypeResponseDto;
import com.turnero.turnero.general.entity.DocumentTypeEntity;
import com.turnero.turnero.general.service.IDocumentTypeService;

@Service
public class DocumentTypeServiceImpl implements IDocumentTypeService {
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private IDocumentTypeDao documentTypeDao;

	@Override
	public List<DocumentTypeResponseDto> documentTypeList() {
		 List<DocumentTypeEntity> documenyoTypeListEntity = documentTypeDao.findAll();
		 return documenyoTypeListEntity.stream().map(info -> modelMapper.map(info, DocumentTypeResponseDto.class))
		            .collect(Collectors.toList());
	}

}
