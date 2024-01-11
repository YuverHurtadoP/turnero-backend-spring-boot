package com.turnero.turnero.access.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turnero.turnero.access.entity.RolEntity;

public interface IRolDao extends JpaRepository<RolEntity, Integer> {

}
