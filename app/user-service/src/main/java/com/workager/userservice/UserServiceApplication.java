package com.workager.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.workager.lib")
public class UserServiceApplication {
  protected UserServiceApplication() {}

  public static void main(final String[] args) {
    SpringApplication.run(UserServiceApplication.class, args);
  }
}
