package com.turnero.turnero.general.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turnero.turnero.general.entity.DepartmentEntity;



public interface IDepartmentDao  extends JpaRepository<DepartmentEntity, Integer>{
	Optional<DepartmentEntity> findByDeparmentId(int deparmentId);
}
