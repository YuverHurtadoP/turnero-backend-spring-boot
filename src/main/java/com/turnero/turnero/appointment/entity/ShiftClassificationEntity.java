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
@Table(name = "clasificacion_turno")
public class ShiftClassificationEntity {
	@Id
	@Column(name = "id_clasificacion")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int shiftClassificationId;
	
	@Column(name = "descripcion")
	private String description;
	
	@Column(name = "activo")
	private boolean active;
	
	@Column(name = "borrado")
	private boolean deleted;

}
