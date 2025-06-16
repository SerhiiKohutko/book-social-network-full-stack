package org.example.booknetworkbackend.feedback;

import jakarta.validation.constraints.*;

public record FeedbackRequest(
    @Positive(message = "200")
    @Min(0)
    @Max(5)
    Double note,
    @NotNull(message = "203")
    @NotBlank(message = "203")
    @NotEmpty(message = "203")
    String comment,
    @NotNull(message = "204")
    Long bookId
) { }
