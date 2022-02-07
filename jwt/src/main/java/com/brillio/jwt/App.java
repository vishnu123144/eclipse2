package com.brillio.jwt;

import io.jsonwebtoken.Claims;

public class App 
{
    public static void main( String[] args )
    {
    	JwtUtil util=new JwtUtil();
    	String token=util.generateToken("AA885", "VISHNU", "SECRETSECRETSECRETSECRETSECRETSECRET");
        System.out.println(token);
        Claims c=util.getClaims("SECRETSECRETSECRETSECRETSECRETSECRET",token);
        System.out.println(c.getId());
        System.out.println(c.getSubject());
    }
}
