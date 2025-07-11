package com.cognizant.spring_learn.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtUtil {

    private static final String SECRET = "ThisIsASecretKeyForJwtSigningThatIsAtLeast32Bytes!";

    private static final Key key = Keys.hmacShaKeyFor(SECRET.getBytes());

    public static String generateToken(String username) {
        long now = System.currentTimeMillis();
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(now + 1000 * 60 * 10)) // 10 min expiry
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }
}
