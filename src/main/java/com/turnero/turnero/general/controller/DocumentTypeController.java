package com.turnero.turnero.general.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.turnero.turnero.general.dto.response.DocumentTypeResponseDto;
import com.turnero.turnero.general.service.IDocumentTypeService;

@RestController
@RequestMapping("/api/document")
public class DocumentTypeController {
	@Autowired
	private IDocumentTypeService documentTypeService;
	
	@GetMapping("/list")
	public ResponseEntity<List<DocumentTypeResponseDto>> getDepartmentList() {
		List<DocumentTypeResponseDto> response = documentTypeService.documentTypeList();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
