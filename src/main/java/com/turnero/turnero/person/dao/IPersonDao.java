package com.turnero.turnero.person.dao;

import java.util.Date;
import java.util.Optional;

 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.turnero.turnero.person.entity.PersonEntity;

import jakarta.transaction.Transactional;

public interface IPersonDao extends JpaRepository<PersonEntity, Integer> {
	Optional<PersonEntity> findByPersonId(Integer personId);
	Optional<PersonEntity> findByNroDni(String nroDni);
	
	@Transactional
	@Modifying
	@Query(value = "update persona SET nombres=?1, apellidos=?2, nro_celular=?3, id_municipio=?4, id_tipo_documento=?5, fecha_actualizacion=?6 where id_persona=?7 ",nativeQuery = true)
	public void updatePerson(String names, String lastname, String phoneNumber, int municipalityId, int docuementTypeId,Date update, int personId);

}
