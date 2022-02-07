package com.brillio.jwt;

import java.sql.Date;
import java.util.Base64;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {

	//generate token
	public String generateToken(
			String id,String subject,String key) {
		
		return Jwts.builder()
				.setId(id)
				.setSubject(subject)
				.setIssuer("VishnuIT")
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.signWith(SignatureAlgorithm.HS256,Base64.getEncoder().encode(key.getBytes()))
				.compact();
		}
	
	   public Claims getClaims(String key,String token) {
		   return Jwts.parser()
				   .setSigningKey(Base64.getEncoder().encode(key.getBytes()))
				   .parseClaimsJws(token)
				   .getBody();
	   }
	
	
	
}
