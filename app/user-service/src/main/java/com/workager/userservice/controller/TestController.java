package com.workager.userservice.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/test/user")
public class TestController {
  @GetMapping("/")
  public String getHelloWorld(final HttpServletRequest servletRequest) {
    String serviceName = "USER-SERVICE";
    String sessionId = servletRequest.getSession().getId();
    return "redirect:/service-status/success.html?serviceName="
        + serviceName
        + "&sessionId="
        + sessionId;
  }
}
