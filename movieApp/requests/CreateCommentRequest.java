package com.project.movieApp.requests;

import lombok.Data;

@Data
public class CreateCommentRequest {

    private Long id;
    private String text;
    private Long userId;
    private Long filmId;

}
