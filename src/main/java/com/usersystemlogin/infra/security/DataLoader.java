package com.usersystemlogin.infra.security;

import com.usersystemlogin.domain.user.User;
import com.usersystemlogin.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
  private final UserRepository repo;
  private final PasswordEncoder encoder;

  public DataLoader(UserRepository repo, PasswordEncoder encoder) {
    this.repo = repo; this.encoder = encoder;
  }

  @Override
  public void run(String... args) {
    if (repo.count() == 0) {
      User user = new User();
      user.setName("user");
      user.setEmail("user@teste.com");
      user.setCpf("03618303009"); //CPF gerado apenas para mock
      user.setPassword(encoder.encode("123456789"));
      repo.save(user);
    }
  }
}

