package com.turnero.turnero.general.service;

import java.util.List;

import com.turnero.turnero.general.dto.response.DocumentTypeResponseDto;
import com.turnero.turnero.general.entity.DocumentTypeEntity;

public interface IDocumentTypeService {
	
	public List<DocumentTypeResponseDto> documentTypeList();
	DocumentTypeResponseDto findByDocumentTypeId(int documentTypeId);
}
