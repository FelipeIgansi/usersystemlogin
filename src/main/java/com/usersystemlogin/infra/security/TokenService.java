package com.usersystemlogin.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.usersystemlogin.domain.user.User;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

  public static final String SECREAT = "R4w74HH1slBgucrExV1QpR6icGdRZH9YUxFFFyPOElTe";
  public static final String ISSUER = "login-auth-api";

  public String generateToken(User user) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(SECREAT);
      String token = JWT.create()
          .withIssuer(ISSUER)
          .withSubject(user.getEmail())
          .withExpiresAt(this.genereteExpirationTime())
          .sign(algorithm);
      return token;
    } catch (JWTCreationException e) {
      throw new RuntimeException("Erro ao fazer a autenticação");
    }
  }

  public String validateToken(String token) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(SECREAT);
      return JWT.require(algorithm)
          .withIssuer(ISSUER)
          .build()
          .verify(token)
          .getSubject();
    } catch (JWTVerificationException e) {
      return null;
    }
  }

  private Instant genereteExpirationTime() {
    return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
  }
}
