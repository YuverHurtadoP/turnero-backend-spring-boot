package com.turnero.turnero.general.entity;

 

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "departamentos")
public class DepartmentEntity {
	
	@Id
	@Column(name = "id_deprtamento")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int deparmentId;
	
	@Column(name = "descripcion")
	private String description;
	
	@OneToMany(mappedBy = "departmentId", cascade = CascadeType.ALL)
	private List<MunicipalityEntity> municipalityEntity;

}
