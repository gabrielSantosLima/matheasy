package com.principal.math.model.entity;

import java.util.Set;

public interface IUsuario {
	
	String getUsername();

	String getPassword();
	
	String getPasswordConfirm();
	
	void setUsername(String username);

	void setPassword(String password);

	void setPasswordConfirm(String passwordConfirm);
	
	Set<Role> getRoles();

	void setRoles(Set<Role> roles);
}
