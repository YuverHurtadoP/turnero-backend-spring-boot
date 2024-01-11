package com.turnero.turnero.general.entity;

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
@Table(name = "tipo_documento")
public class DocumentTypeEntity {
	@Id
	@Column(name = "id_tipo_documento")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int documentTypeId;
	
	@Column(name = "descripcion")
	private String description;

}
