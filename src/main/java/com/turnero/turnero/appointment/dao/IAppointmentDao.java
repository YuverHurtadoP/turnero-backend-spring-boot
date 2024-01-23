package com.turnero.turnero.appointment.dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.turnero.turnero.appointment.entity.AppointmentRequestEntity;

import jakarta.transaction.Transactional;

public interface IAppointmentDao extends JpaRepository<AppointmentRequestEntity, Integer>{
	@Transactional
	@Modifying
	@Query(value = "update solicitud_cita SET estado_turno_id=3,fecha_para_cita=?1, id_medico=?2 where id_cita=?3 and eliminado=false",nativeQuery = true)
	public void acceptAppointment(Date dateAppointment, Integer personalMedicalId, Integer appointmentId );
	
	@Transactional
	@Modifying
	@Query(value = "update solicitud_cita SET estado_turno_id=?1 where id_cita=?2 and eliminado=false",nativeQuery = true)
	public void changeStatusAppointment(Integer statusAppointment, Integer appointmentId );
	
	@Transactional
	@Query(value = "select * from  solicitud_cita where id_paciente=?1",nativeQuery = true)
	List<AppointmentRequestEntity>findByPatientId(Integer idPatient);
	
	@Transactional
	@Query(value = "select * from  solicitud_cita where id_medico=?1",nativeQuery = true)
	List<AppointmentRequestEntity>findByPersonalMedicoId(Integer idMedico);
	
	Optional<AppointmentRequestEntity> findByAppointmentId(Integer appointmentId);

}
