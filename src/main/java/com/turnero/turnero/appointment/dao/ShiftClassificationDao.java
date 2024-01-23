package com.turnero.turnero.appointment.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turnero.turnero.appointment.entity.ShiftClassificationEntity;

public interface ShiftClassificationDao extends JpaRepository< ShiftClassificationEntity, Integer> {
	
	Optional<ShiftClassificationEntity> findByShiftClassificationId(int id);

}
