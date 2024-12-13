package com.workager.userservice.service.impl;

import com.workager.lib.entities.User;
import com.workager.lib.payloads.UserD;
import com.workager.lib.repositories.UserRepository;
import com.workager.userservice.service.CrudService;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrudServiceImpl implements CrudService {
  private final UserRepository userRepository;
  private final ModelMapper modelMapper;

  @Autowired
  public CrudServiceImpl(final UserRepository userRepository, final ModelMapper modelMapper) {
    this.userRepository = userRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public UserD createUser(final UserD userD) {
    // Write authorization logic here, to control unauthorized registrations.
    User user = this.userRepository.save(this.modelMapper.map(userD, User.class));
    return this.modelMapper.map(user, UserD.class);
  }

  @Override
  public UserD getUserById(final UUID id) {
    return null;
  }

  @Override
  public List<UserD> getAllUsers() {
    return this.userRepository.findAll().stream()
        .map(e -> this.modelMapper.map(e, UserD.class))
        .collect(Collectors.toList());
  }

  @Override
  public UserD updateUser(final UserD user) {
    return null;
  }

  @Override
  public UserD deleteUserByID(final UUID id) {
    return null;
  }
}
