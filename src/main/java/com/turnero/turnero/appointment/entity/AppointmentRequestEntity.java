package com.turnero.turnero.appointment.entity;

import java.util.Date;

import com.turnero.turnero.person.entity.PersonEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
 

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "solicitud_cita")
public class AppointmentRequestEntity {
	
	
	@Id
	@Column(name = "id_cita")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int appointmentId;
	
	@Column(name = "fecha_registro")
	private Date createdAp;
	
	@Column(name = "fecha_actualizacion")
	private Date updatedAp;
	
	@Column(name = "eliminado")
	private boolean deleted;
	
	@Column(name = "fecha_para_cita")
	private Date dateAppointment;
	
	@ManyToOne(fetch = jakarta.persistence.FetchType.LAZY)
    @JoinColumn(name = "id_clasificacion_turno") 
	private ShiftClassificationEntity shiftClassificationId;
	
	@ManyToOne(fetch = jakarta.persistence.FetchType.LAZY)
    @JoinColumn(name = "id_paciente") 
	private PersonEntity patient;
	
	@ManyToOne(fetch = jakarta.persistence.FetchType.LAZY)
    @JoinColumn(name = "estado_turno_id") 
	private ShiftStatusEntity shiftStatusId;
	
	@Column(name = "id_medico")
	private int personalDoctor;
	
	
 
	


	
}
