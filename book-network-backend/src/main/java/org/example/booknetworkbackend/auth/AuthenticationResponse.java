package org.example.booknetworkbackend.auth;

import lombok.Builder;

@Builder
public record AuthenticationResponse(
        String token
) { }
