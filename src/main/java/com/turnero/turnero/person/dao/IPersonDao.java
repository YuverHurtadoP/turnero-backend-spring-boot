package com.turnero.turnero.person.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turnero.turnero.person.entity.PersonEntity;

public interface IPersonDao extends JpaRepository<PersonEntity, Integer> {
	Optional<PersonEntity> findByPersonId(Integer personId);
	Optional<PersonEntity> findByNroDni(String nroDni);

}
