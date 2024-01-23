package com.turnero.turnero.access.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turnero.turnero.access.entity.UserEntity;

public interface IUserDao  extends JpaRepository<UserEntity, Integer>{
	public Optional<UserEntity> findByEmail(String email);
	public Optional<UserEntity> findByPersonId(int personId);
}
