package com.turnero.turnero.access.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turnero.turnero.access.entity.RolEntity;

public interface IRolDao extends JpaRepository<RolEntity, Integer> {
	Optional<RolEntity> findByrolId(int rolId);
	
	}
