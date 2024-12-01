package com.workager.userservice.service;

import com.workager.lib.payloads.UserD;
import java.util.List;
import java.util.UUID;

public interface CrudService {
  UserD createUser(UserD user);

  UserD getUserById(UUID id);

  List<UserD> getAllUsers(); // to be removed

  UserD updateUser(UserD user);

  UserD deleteUserByID(UUID id);
}
