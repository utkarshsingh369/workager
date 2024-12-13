package com.workager.authservice.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/auth/health")
public class TestController {
  @GetMapping("/")
  public String getHelloWorld(final HttpServletRequest servletRequest) {
    String serviceName = "AUTH-SERVICE";
    String sessionId = servletRequest.getSession().getId();
    return "redirect:/service-status/success.html?serviceName="
        + serviceName
        + "&sessionId="
        + sessionId;
  }
}
