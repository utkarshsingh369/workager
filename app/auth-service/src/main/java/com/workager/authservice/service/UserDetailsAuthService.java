package com.workager.authservice.service;

import com.workager.authservice.principal.UserPrincipal;
import com.workager.lib.entities.User;
import com.workager.lib.payloads.UserD;
import com.workager.lib.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsAuthService implements UserDetailsService {
  private final UserRepository userRepository;
  private final ModelMapper modelMapper;

  @Autowired
  public UserDetailsAuthService(
      final UserRepository userRepository, final ModelMapper modelMapper) {
    this.userRepository = userRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
    User user = this.userRepository.findByUsername(username);
    UserPrincipal userPrincipal = new UserPrincipal(this.modelMapper.map(user, UserD.class));
    return userPrincipal;
  }
}
