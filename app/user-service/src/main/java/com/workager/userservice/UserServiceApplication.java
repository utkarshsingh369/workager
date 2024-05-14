package com.workager.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserServiceApplication {
  protected UserServiceApplication() {}

  public static void main(final String[] args) {
    SpringApplication.run(UserServiceApplication.class, args);
  }
}
