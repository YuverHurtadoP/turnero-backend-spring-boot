package com.turnero.turnero.appointment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "estado_turno")
public class ShiftStatusEntity {
	
	@Id
	@Column(name = "id_estado")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer shiftStatusId;
	
	@Column(name = "descripcion")
	private String description;
	
	@Column(name = "activo")
	private boolean active;
	
	@Column(name = "eliminado")
	private boolean deleted;

}
