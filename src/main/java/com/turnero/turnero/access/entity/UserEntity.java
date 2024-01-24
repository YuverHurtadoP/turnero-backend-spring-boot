package com.turnero.turnero.access.entity;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
@Table(name = "usuarios")
public class UserEntity implements UserDetails{
	
	@Id
	@Column(name = "usuario_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@Column(name = "usuario")
	private String email;
	
	@Column(name = "clave")
	private String password;
	
	@Column(name = "activo")
	private boolean active;
	
	@Column(name = "fecha_creacion")
	private Date createdAp;
	
	@Column(name = "fecha_actualizacion")
	private Date updatedAp;
	
	@ManyToOne
    @JoinColumn(name = "rol_id")
	private RolEntity rolUser; // estaba  private int rolUser;
	
	@Column(name = "id_persona")
	private int personId;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		 
		return List.of(new SimpleGrantedAuthority((rolUser.getDescription())));
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
