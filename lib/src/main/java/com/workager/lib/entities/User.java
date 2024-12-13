package com.workager.lib.entities;

import com.workager.lib.constants.DataValidationConstants;
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

  @Column(nullable = false, length = DataValidationConstants.USER_PASSWORD_MAX_LENGTH)
  private String password;

  @ElementCollection(
      fetch =
          FetchType
              .LAZY) // To map a table for collection of basic (int, string, etc.) or @Embeddable
  // entities. Here, Set<String>.
  @CollectionTable(
      name = "user_roles",
      joinColumns = @JoinColumn(name = "user_id")) // To customize the mapped table
  @Enumerated(EnumType.STRING) // To define how to store enum values in db (STRING or ORDINAL).
  @Column(nullable = false, name = "role")
  private Set<Role> role;

  @CreationTimestamp
  @Column(nullable = false, updatable = false)
  private Instant createdAt;
}
