package com.tuan.authservice.service;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.Date;

@Slf4j
@Service
public class JwtService  {
    @Value("${jwt.access-key}")
    private String accessKey;
    public String generateToken () {
        log.info(accessKey);
        return Jwts.builder()
                .claim("user","name")
                .expiration(new Date(System.currentTimeMillis()+3600*1000))
                .signWith(Keys.hmacShaKeyFor(accessKey.getBytes()))
                .compact();
    }
    public Claims getClaimsFromToken(String token) {
        return Jwts.parser()
                .verifyWith(Keys.hmacShaKeyFor(accessKey.getBytes())) // Xác thực key
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
    public String getBody(String token) {
        return getClaimsFromToken(token).get("user",String.class);
    }
}
