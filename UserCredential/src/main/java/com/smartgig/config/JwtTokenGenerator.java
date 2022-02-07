package com.smartgig.config;

import java.util.Map;

import com.smartgig.model.Login;
import com.smartgig.model.Registration;

public interface JwtTokenGenerator {
	 Map<String,String> generateToken(Login login);
}
