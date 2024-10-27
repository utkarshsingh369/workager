package com.workager.lib.repositories;

import com.workager.lib.entities.User;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, UUID> {}
