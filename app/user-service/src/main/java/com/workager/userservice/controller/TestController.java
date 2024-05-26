package com.workager.userservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user/test")
public class TestController {
  @GetMapping("/")
  public String getHelloWorld() {
    return "[USER-SERVICE] Hello World";
  }
}
