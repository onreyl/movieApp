package com.project.movieApp.controllers;

import com.project.movieApp.entities.Comment;
import com.project.movieApp.requests.CreateCommentRequest;
import com.project.movieApp.requests.UpdateCommentRequest;
import com.project.movieApp.responses.CommentResponse;
import com.project.movieApp.services.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
@AllArgsConstructor
public class CommentController {

    private CommentService commentService;

    @GetMapping("/getAll")
    public List<CommentResponse> getAllComments(@RequestParam Optional<Long> userId,
                                                @RequestParam Optional<Long> filmId) {

        return commentService.getAllComments(userId, filmId);
    }

    @GetMapping("/{commentId}")
    public Comment getOneComment(@PathVariable Long commentId) {

        return commentService.getOneComment(commentId);
    }

    @PostMapping("/add")
    public Comment createOneComment(@RequestBody CreateCommentRequest newCommentRequest) {

        return commentService.createOneComment(newCommentRequest);
    }

    @PutMapping("/update")
    public Comment updateComment(@RequestBody UpdateCommentRequest updateCommentRequest) {

        return commentService.updateComment(updateCommentRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Long commentId) {

        commentService.deleteComment(commentId);
    }
}
