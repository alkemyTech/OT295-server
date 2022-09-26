package com.alkemy.ong.auth.jwt;

import com.alkemy.ong.domain.entity.UserEntity;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class JwtUtils {

    private static final String SECRET_KEY = "key";
    private static final String BEARER_TOKEN = "Bearer %s";
    private static final String AUTHORITIES = "authorities";
    private static final String BEARER_PART = "Bearer ";
    private static final String EMPTY = "";

    public Claims extractAllClaims(String authorizationHeader) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY.getBytes(StandardCharsets.UTF_8))
                .parseClaimsJws(getToken(authorizationHeader))
                .getBody();
    }

    private String createToken(String subject, String role) {
        String token = Jwts.builder()
                .claim(AUTHORITIES, convertTo(AuthorityUtils.commaSeparatedStringToAuthorityList(role)))
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY.getBytes(StandardCharsets.UTF_8)).compact();
        return String.format(BEARER_TOKEN, token);
    }

    public String generateToken(UserDetails userDetails) {
        UserEntity user = (UserEntity) userDetails;
        return createToken(user.getUsername(), user.getRoles().get(0).getName());
    }

    public boolean isTokenSet(String authorizationHeader) {
        return authorizationHeader != null && authorizationHeader.startsWith(BEARER_PART);
    }

    private String getToken(String authorizationHeader) {
        return authorizationHeader.replace(BEARER_PART, EMPTY);
    }

    private List<String> convertTo(List<GrantedAuthority> grantedAuthorities) {
        return grantedAuthorities.stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
    }


}
