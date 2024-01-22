package com.turnero.turnero.appointment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turnero.turnero.appointment.entity.ShiftClassificationEntity;

public interface ShiftClassificationDao extends JpaRepository< ShiftClassificationEntity, Integer> {

}
