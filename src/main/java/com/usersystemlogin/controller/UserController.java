package com.usersystemlogin.controller;

import com.usersystemlogin.domain.user.User;
import com.usersystemlogin.dto.UserResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
  @GetMapping
  public ResponseEntity<?> getUser(Authentication authentication) {
    try {
      User user = (User) authentication.getPrincipal();
      UserResponseDTO userResponse = new UserResponseDTO(
          user.getId(),
          user.getName(),
          user.getEmail()
      );

      return ResponseEntity.ok(userResponse);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("Erro ao buscar informações do usuário");
    }
  }
}
