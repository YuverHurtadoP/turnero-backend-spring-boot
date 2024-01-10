package com.turnero.turnero.general.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turnero.turnero.general.entity.DepartmentEntity;



public interface IDepartmentDao  extends JpaRepository<DepartmentEntity, Integer>{

}
