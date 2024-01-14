package com.turnero.turnero.general.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turnero.turnero.general.entity.DocumentTypeEntity;

 

public interface IDocumentTypeDao extends JpaRepository<DocumentTypeEntity, Integer> {
	Optional<DocumentTypeEntity> findByDocumentTypeId(int documentTypeId);
}
