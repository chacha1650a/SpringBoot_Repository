package com.korit.todoapi.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.apache.el.parser.Token;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.Instant;
import java.util.Date;

@Component
public class JwtUtil {
    @Value("${jwt}") // setter로 주입 (객체 생성되어야 가능)
    private String secret;

    private SecretKey key;

   // : 생성된 후 (생성 후 한 번 포스트) 여기서 의미하는 post는 뒷단을 의미하는 post
    public JwtUtil(@Value("${jwt}") String secret) {
        key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

//    public JwtUtil(@Value("${jwt}") String secret) {
//        key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
//    } 생성될 때 주입

    public String createToken(String id) {
        return Jwts.builder()
                .id(id)
                .expiration(new Date(new Date().getTime() + (60000l * 60l * 24l)))
                .signWith(key, Jwts.SIG.HS512)
                .compact();
    }

    public Jws<Claims> parseAndValidate(String token) {
        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token);
    }
}
