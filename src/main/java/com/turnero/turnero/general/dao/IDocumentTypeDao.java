package com.turnero.turnero.general.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turnero.turnero.general.entity.DocumentTypeEntity;

 

public interface IDocumentTypeDao extends JpaRepository<DocumentTypeEntity, Integer> {

}