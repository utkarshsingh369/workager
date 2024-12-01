package com.workager.lib.entities;

import com.workager.lib.enums.Role;
import jakarta.persistence.*;
import java.time.Instant;
import java.util.Set;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

/**
 * Represents a User entity with a unique {@link UUID} identifier. The UUID is automatically
 * generated upon instantiation.
 */
@Entity
@Getter
@Setter
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Column(nullable = true, unique = true)
  private String email;

  @Column(nullable = false, unique = true)
  private String username;

  @Column(nullable = false, length = 50)
  private String password;

  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
  @Enumerated(EnumType.STRING)
  @Column(nullable = false, name = "role")
  private Set<Role> role;

  @CreationTimestamp
  @Column(nullable = false, updatable = false)
  private Instant createdAt;
}
