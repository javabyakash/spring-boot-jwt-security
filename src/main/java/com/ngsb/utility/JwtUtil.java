package com.ngsb.utility;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
	
	@Value("${app.secret}")
	private String secret;
	
	// 7. Validate token username and request username and also expDate
	public boolean validateToken(String token, String subject) {
		String usernameInToken = getUsername(token);
		return (usernameInToken.equals(subject) && !isTokenExpired(token));
	}
	
	// 6. Check token expiry 
	public boolean isTokenExpired(String token) {
		final Date expDate = getExpDate(token);
		return expDate.before(new Date());
	}
	
	// 5. Generate token with empty claims
	public String generateToken(String subject) {
		Map<String, Object> claims = new HashMap<>();
		return generateToken(claims,subject);
	}
	
	// 4. Read user name
	public String getUsername(String token) {
		return getClaims(token).getSubject();
	}
	
	// 3. Read exp date
	public Date getExpDate(String token) {
		return getClaims(token).getExpiration();
	}
	
	// 2. Read claims
	private Claims getClaims(String token) {
		return Jwts.parser()
				.setSigningKey(secret)
				.parseClaimsJws(token)
				.getBody();
	}
	
	// 1. Generate token
	private String generateToken(Map<String, Object> claims, String subject) {
		return Jwts.builder()
				.setClaims(claims)
				.setSubject(subject)
				.setIssuer("AKASH")
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(10)))
				.signWith(SignatureAlgorithm.HS512, secret)
				.compact();
	}
}
