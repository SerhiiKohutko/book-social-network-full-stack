package org.example.booknetworkbackend.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record AuthenticationRequest(
        @NotEmpty(message = "Email name is required")
        @NotBlank
        @Email(message = "Email is not formatted")
        String email,
        @NotEmpty(message = "Password name is required")
        @NotBlank
        @Size(min = 8, message = "Password should be 8 characters long minimum")
        String password
) { }
