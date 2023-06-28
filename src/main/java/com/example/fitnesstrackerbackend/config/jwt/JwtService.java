package com.example.fitnesstrackerbackend.config.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;

@Service
public class JwtService {

  private static final String SECRET_KEY = "203598347ac336e154b607556ca3790dcf52d08b9cdcc421d6c8be93c333c9f7";

  public String extractUsername(String token) {
    return null;
  }

  public Claims extractAllClaims(String token) {
    return Jwts
            .parserBuilder()
            .setSigningKey(getSigningKey())
            .build().parseClaimsJws(token).getBody();

  }

  private Key getSigningKey() {
    byte[] secretBytes = Decoders.BASE64.decode(SECRET_KEY);
    return Keys.hmacShaKeyFor(secretBytes);
  }

}
