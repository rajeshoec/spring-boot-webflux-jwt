package com.ard333.springbootwebfluxjjwt.model;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ard333.springbootwebfluxjjwt.model.security.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User implements UserDetails {
	private static final long serialVersionUID = 1L;

	private String username;

	private String password;

	private Boolean enabled;

	private List<Role> roles;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String username, String password, Boolean enabled, List<Role> roles) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.roles = roles;
	}

	@Override
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return this.enabled;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.roles.stream().map(authority -> new SimpleGrantedAuthority(authority.name()))
				.collect(Collectors.toList());
	}

	@JsonIgnore
	@Override
	public String getPassword() {
		return password;
	}

	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}