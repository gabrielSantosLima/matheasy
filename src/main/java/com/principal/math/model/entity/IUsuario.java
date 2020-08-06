package com.principal.math.model.entity;

public interface IUsuario {
	
	String getUsername();

	String getPassword();
	
	String getPasswordConfirm();
	
	void setUsername(String username);

	void setPassword(String password);

	void setPasswordConfirm(String passwordConfirm);
	
	Role getRole();

	void setRole(Role role);
}
