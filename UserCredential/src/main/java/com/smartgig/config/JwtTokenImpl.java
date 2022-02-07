package com.smartgig.config;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.smartgig.model.Login;
//import com.smartgig.model.Registration;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtTokenImpl implements JwtTokenGenerator{
    @Value("${jwt.secret.key}")
    private String secretKey;


	@Override
	public Map<String, String> generateToken(Login login) {
		String token = Jwts.builder().setSubject(login.getEmail())
                .setIssuer("APPIssuer")
                .setIssuedAt(new Date())
                //using HS256 algorithm for generating token
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
        return Map.of("token", token);
	}

}
