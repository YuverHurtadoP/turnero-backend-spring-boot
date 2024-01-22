package com.turnero.turnero.appointment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turnero.turnero.appointment.entity.AppointmentRequestEntity;

public interface IAppointmentDao extends JpaRepository<AppointmentRequestEntity, Integer>{

}
