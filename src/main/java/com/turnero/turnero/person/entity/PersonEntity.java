package com.turnero.turnero.person.entity;

import java.util.Date;
import java.util.List;

 
import com.turnero.turnero.general.entity.DocumentTypeEntity;
import com.turnero.turnero.general.entity.MunicipalityEntity;

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
@Table(name = "persona")
public class PersonEntity {
	@Id
	@Column(name = "id_persona")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int personId;
	
	@Column(name = "nombres")
	private String name;
	
	@Column(name = "apellidos")
	private String lastName;
	
	@Column(name = "nro_documentos", unique=true)
	private String nroDni;
	
	@Column(name = "nro_celular")
	private String phoneNumber;
	
	@Column(name = "activo")
	private boolean active;
	
	@Column(name = "fecha_creacion")
	private Date createdAp;
	
	@Column(name = "fecha_actualizacion")
	private Date updatedAp;
	
	@ManyToOne(fetch = jakarta.persistence.FetchType.LAZY)
    @JoinColumn(name = "id_municipio") // Clave foránea 
	private MunicipalityEntity municipalityIdPerson;
	
	 
	@ManyToOne(fetch = jakarta.persistence.FetchType.LAZY)
    @JoinColumn(name = "id_tipo_documento") // Clave foránea 
	private DocumentTypeEntity documentTypeId;
}
