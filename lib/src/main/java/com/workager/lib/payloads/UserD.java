package com.workager.lib.payloads;

import com.workager.lib.constants.DataValidationConstants;
import com.workager.lib.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.time.Instant;
import java.util.Set;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserD {
  private UUID id;

  @Email(message = "Not a valid email address")
  private String email;

  @NotEmpty
  @Size(
      min = DataValidationConstants.USER_USERNAME_MIN_LENGTH,
      message = "Username must be of at least 3 letters")
  private String username;

  @NotEmpty
  @Pattern(
      regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\\$%\\^&\\*]).{8,}$",
      message = "Password doesn't meet the requirement")
  private String password;

  @NotEmpty private Set<Role> role;

  private Instant createdAt;
}
