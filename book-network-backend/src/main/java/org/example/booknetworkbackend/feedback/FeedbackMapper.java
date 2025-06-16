package org.example.booknetworkbackend.feedback;

import lombok.RequiredArgsConstructor;
import org.example.booknetworkbackend.book.Book;
import org.example.booknetworkbackend.book.Feedback;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class FeedbackMapper{

    public Feedback toFeedback(FeedbackRequest request){
        return Feedback.builder()
                .comment(request.comment())
                .note(request.note())
                .book(Book.builder()
                        .id(request.bookId())
                        .archived(false)
                        .shareable(false)
                        .build())
                .build();
    }

    public FeedbackResponse toFeedbackResponse(Feedback feedback, Long id){
        return FeedbackResponse.builder()
                .note(feedback.getNote())
                .comment(feedback.getComment())
                .ownFeedback(Objects.equals(feedback.getCreatedBy(), id))
                .build();
    }
}
