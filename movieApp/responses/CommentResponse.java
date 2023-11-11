package com.project.movieApp.responses;

import com.project.movieApp.entities.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CommentResponse {

    private Long id;
    private String text;

    public CommentResponse(Comment comment) {
        this.id = comment.getId();
        this.text = comment.getText();
    }
}
