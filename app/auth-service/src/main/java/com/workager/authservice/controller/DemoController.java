package com.workager.authservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/demo")
public class DemoController {
  @GetMapping("/info")
  private ResponseEntity<String> getInfo() {
    return new ResponseEntity<>("very sensitive information", HttpStatus.OK);
  }
}
