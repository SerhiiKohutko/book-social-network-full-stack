package org.example.booknetworkbackend.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

public enum ErrorCode {

    NO_CODE(0,"No code", NOT_IMPLEMENTED ),
    INCORRECT_CURRENT_PASSWORD(300, "Current password is incorrect", BAD_REQUEST),
    NEW_PASSWORD_DOESNT_MATCH(301, "New password doesnt match", BAD_REQUEST),
    ACCOUNT_DISABLED(303, "Account is disabled", FORBIDDEN),
    BAD_CREDENTIALS(304, "Login/password is incorrect", FORBIDDEN),
    ACCOUNT_LOCKED(302, "User account is locked", FORBIDDEN);

    @Getter
    private final int code;
    @Getter
    private final String description;
    @Getter
    private final HttpStatus httpStatusCode;

    ErrorCode(int code, String description, HttpStatus httpStatusCode) {
        this.code = code;
        this.description = description;
        this.httpStatusCode = httpStatusCode;
    }
}
