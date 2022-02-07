package com.springsecurity.models;

public class AuthenticationResponse {

	public final String jwt;

	public AuthenticationResponse(String jwt) {
		super();
		this.jwt = jwt;
	}
	
	
	public String getJwt() {
		return jwt;
	}
	
}
