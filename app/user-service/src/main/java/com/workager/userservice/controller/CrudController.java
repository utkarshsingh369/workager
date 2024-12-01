package com.workager.userservice.controller;

import com.workager.lib.payloads.UserD;
import com.workager.userservice.service.CrudService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
public class CrudController {
  private final CrudService crudService;

  @Autowired
  public CrudController(final CrudService crudService) {
    this.crudService = crudService;
  }

  @PostMapping("/create")
  public ResponseEntity<UserD> create(@Valid @RequestBody final UserD user) {
    try {
      UserD userD = this.crudService.createUser(user);
      return new ResponseEntity<>(userD, HttpStatus.CREATED);
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/")
  public ResponseEntity<List<UserD>> getAllUsers() {
    try {
      List<UserD> users = this.crudService.getAllUsers();
      return new ResponseEntity<>(users, HttpStatus.OK);
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
