package com.user.system.application.util;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {
	
	private String secret="agagaggaghhaiAHAHHAHAbbjhjhjh";
	// generate token 
	
	public String generateToken(String subject) {
		
		return Jwts.builder()
				.setSubject(subject)
				.setIssuer("sanjay")
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+TimeUnit.MINUTES.toMillis(15)))
				.signWith(SignatureAlgorithm.HS512, secret.getBytes())
				.compact();
		
	}
	
	// read token data
	// read claims
	
	public Claims getClaims(String token) {
		
		return Jwts.parser()
				.setSigningKey(secret.getBytes())
				.parseClaimsJwt(token)
				.getBody();
		
	}
	
	// 
	

}
