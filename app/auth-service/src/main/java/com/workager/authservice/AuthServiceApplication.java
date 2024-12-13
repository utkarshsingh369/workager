package com.workager.authservice;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.workager.lib")
@EnableJpaRepositories(basePackages = "com.workager.lib")
public class AuthServiceApplication {
  protected AuthServiceApplication() {}

  public static void main(final String[] args) {
    SpringApplication.run(AuthServiceApplication.class, args);
  }

  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }
}
