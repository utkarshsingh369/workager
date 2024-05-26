package com.workager.authservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth/test")
public class TestController {
  @GetMapping("/")
  public String getHelloWorld() {
    return "[AUTH-SERVICE] Hello World";
  }
}
