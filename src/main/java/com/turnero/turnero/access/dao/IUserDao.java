package com.turnero.turnero.access.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turnero.turnero.access.entity.UserEntity;
@Repository
public interface IUserDao  extends JpaRepository<UserEntity, Integer>{
	public Optional<UserEntity> findByEmail(String email);
	public Optional<UserEntity> findByPersonId(int personId);
}
