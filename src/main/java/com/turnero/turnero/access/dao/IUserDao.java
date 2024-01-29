package com.turnero.turnero.access.dao;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.turnero.turnero.access.entity.UserEntity;

import jakarta.transaction.Transactional;
@Repository
public interface IUserDao  extends JpaRepository<UserEntity, Integer>{
	public Optional<UserEntity> findByEmail(String email);
	public Optional<UserEntity> findByPersonId(int personId);
	
	@Transactional
	@Modifying
	@Query(value = "update usuarios SET clave=?1, fecha_actualizacion=?2 where usuario=?3 ",nativeQuery = true)
	public void recoveryPassword(String password, Date update, String userEmail);

	
	 
}
