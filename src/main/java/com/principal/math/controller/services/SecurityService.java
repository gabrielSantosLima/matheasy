package com.principal.math.controller.services;

public interface SecurityService {
	
	String findLoggedinUsername();
	
	void autoLogin(String username, String password);
}
