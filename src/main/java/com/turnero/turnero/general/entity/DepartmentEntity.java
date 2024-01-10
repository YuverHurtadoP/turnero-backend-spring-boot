package com.turnero.turnero.general.entity;

 

import java.util.Date;
import java.util.Set;

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
@Table(name = "departamentos")
public class DepartmentEntity {
	
	@Id
	@Column(name = "id_departamento")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int deparmentId;
	
	@Column(name = "descripcion")
	private String description;

}
