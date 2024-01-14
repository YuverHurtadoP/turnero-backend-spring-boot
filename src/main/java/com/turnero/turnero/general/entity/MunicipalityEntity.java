package com.turnero.turnero.general.entity;

 

import java.util.List;

import com.turnero.turnero.person.entity.PersonEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "municipio")
public class MunicipalityEntity {
	@Id
	@Column(name = "id_municipio")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int  municipalityId;
	
	@Column(name = "descripcion")
	private String description;
	
	@ManyToOne(fetch = jakarta.persistence.FetchType.LAZY)
    @JoinColumn(name = "id_deprtamento") // Clave foránea 
	private DepartmentEntity departmentId;
	
	@OneToMany(mappedBy = "municipalityIdPerson", cascade = CascadeType.ALL)
	private List<PersonEntity> person;

}
