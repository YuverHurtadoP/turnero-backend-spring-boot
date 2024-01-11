package com.turnero.turnero.general.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turnero.turnero.general.entity.MunicipalityEntity;

public interface IMunicipalityDao extends JpaRepository<MunicipalityEntity, Integer> {

}
