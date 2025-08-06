package com.usersystemlogin.dto;

public record ResetPasswordRequestDTO(String email, String token, String password){ }