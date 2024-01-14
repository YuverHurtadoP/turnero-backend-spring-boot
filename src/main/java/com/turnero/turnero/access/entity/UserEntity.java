package com.turnero.turnero.access.entity;

import java.util.Date;

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
@Table(name = "usuarios")
public class UserEntity {
	
	@Id
	@Column(name = "usuario_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@Column(name = "usuario")
	private String email;
	
	@Column(name = "clave")
	private String password;
	
	@Column(name = "activo")
	private boolean active;
	
	@Column(name = "fecha_creacion")
	private Date createdAp;
	
	@Column(name = "fecha_actualizacion")
	private Date updatedAp;
	
	@Column(name = "rol_id")
	private int rolUser;
	
	@Column(name = "id_persona")
	private int personId;

}
