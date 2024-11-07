package com.javali.service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.javali.infraestructure.entity.UserEntity;

public class TokenService {

  // Criar token de login
  public String createToken(UserEntity userEntity) {
    try {
      Algorithm algoritmo = Algorithm.HMAC256("1234");
      LocalDateTime dataExpiracao = LocalDateTime.now().plusHours(2);
      return JWT.create()
        .withIssuer("Java Li") // insere a que empresa pertence o token
        .withSubject(userEntity.getLogin()) // insere o usuario do login
        .withExpiresAt(dataExpiracao.toInstant(ZoneOffset.of("-03:00"))) // define em quanto tempo vai expirar o token, o .toInstant(ZoneOffset.of("-03:00")) é configuração padrão
        .sign(algoritmo); // criando a estratégia do token
      // é possível inserir varias informações apos o método create() para implementar no token que está sendo criado
    } catch (JWTCreationException e) {
      throw new RuntimeException("Erro ao criar token", e);
    }
  }

  public String buscarUsuarioToken(String token) { // Buscar o usuário dentro de um token que ja foi criado
    try {
      Algorithm algoritmo = Algorithm.HMAC256("1234");

      return JWT.require(algoritmo) // infomar o mesmo algoritmo que criou o token
        .withIssuer("Java Li")// deve infomar o mesmo Issuer que o token criado
        .build() // cria o token
        .verify(token) // verificar o token que foi criado com o token já existente
        .getSubject(); // pegar o subject, no caso o usuário, pois foi definito esse subject ao criar o token

    } catch (JWTVerificationException e) {
      throw new RuntimeException("Token incorreto", e);
    }
  }
}
