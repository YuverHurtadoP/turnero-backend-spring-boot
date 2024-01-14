package com.turnero.turnero.general.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turnero.turnero.general.entity.MunicipalityEntity;

public interface IMunicipalityDao extends JpaRepository<MunicipalityEntity, Integer> {
	Optional<MunicipalityEntity> findByMunicipalityId(int municipalityId);
}
