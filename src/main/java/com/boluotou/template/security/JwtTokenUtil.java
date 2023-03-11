package com.boluotou.template.security;

import com.boluotou.template.entity.User;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;

@Slf4j
@Component
public class JwtTokenUtil {

  private static final long EXPIRE_DURATION = 24 * 60 * 60 * 1000 * 7; // 24 hour * 7

  @Value("${app.jwt.secret}")
  private String SECRET_KEY;

  public String generateToken(User user) {
    return Jwts.builder()
      .setSubject(user.getUserId())
      .setIssuer("CodeJava")
      .claim("roles", Arrays.toString(user.getRoles().toArray()))
      .setIssuedAt(new Date())
      .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
      .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
      .compact();
  }

  public boolean validateAccessToken(String token) {
    try {
      Jwts.parserBuilder().setSigningKey(SECRET_KEY).build().parseClaimsJws(token);
      return true;
    } catch (ExpiredJwtException ex) {
      log.error("JWT expired", ex);
    } catch (IllegalArgumentException ex) {
      log.error("Token is null, empty or only whitespace", ex);
    } catch (MalformedJwtException ex) {
      log.error("JWT is invalid", ex);
    } catch (UnsupportedJwtException ex) {
      log.error("JWT is not supported", ex);
    } catch (SignatureException ex) {
      log.error("Signature validation failed", ex);
    }
    return false;
  }

  public String getSubject(String token) {
    return parseClaims(token).getSubject();
  }

  public Claims parseClaims(String token) {
    return Jwts.parserBuilder()
      .setSigningKey(SECRET_KEY)
      .build()
      .parseClaimsJws(token)
      .getBody();
  }
}
