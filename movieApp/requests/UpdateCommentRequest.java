package com.project.movieApp.requests;

import lombok.Data;

@Data
public class UpdateCommentRequest {

    private Long commentId;
    private String text;
}
