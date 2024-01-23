package com.turnero.turnero.appointment.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turnero.turnero.appointment.entity.ShiftStatusEntity;

public interface IShiftStatusDao extends JpaRepository<ShiftStatusEntity, Integer>{
	Optional<ShiftStatusEntity>findByShiftStatusId(int id);

}
