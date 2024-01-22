package com.turnero.turnero.general.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.turnero.turnero.general.entity.MunicipalityEntity;

import jakarta.transaction.Transactional;

public interface IMunicipalityDao extends JpaRepository<MunicipalityEntity, Integer> {
	Optional<MunicipalityEntity> findByMunicipalityId(int municipalityId);
	@Transactional
	@Query(value="select * from municipio where id_departamento	= ?1",nativeQuery = true)
	List<MunicipalityEntity> findByDepartmentId(Integer departmentId);
}
