package org.example.booknetworkbackend.book;

import lombok.Builder;

@Builder
public record BorrowedBookResponse(
        Long id,
        String title,
        String authorName,
        String isbn,
        double rate,
        boolean returned,
        boolean returnedApproved
) {
}
