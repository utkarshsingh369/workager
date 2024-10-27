package com.workager.lib.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.UUID;

/**
 * Represents a User entity with a unique {@link UUID} identifier. The UUID is automatically
 * generated upon instantiation.
 */
@Entity
public class User {
  @Id private UUID id;

  public User() {
    this.id = UUID.randomUUID();
  }
}
