package com.workager.authservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuthServiceApplication {
  protected AuthServiceApplication() {}

  public static void main(final String[] args) {
    SpringApplication.run(AuthServiceApplication.class, args);
  }
}
