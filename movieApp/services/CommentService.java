package com.project.movieApp.services;

import com.project.movieApp.entities.Comment;
import com.project.movieApp.entities.Film;
import com.project.movieApp.entities.User;
import com.project.movieApp.repository.CommentRepository;
import com.project.movieApp.requests.CreateCommentRequest;
import com.project.movieApp.requests.UpdateCommentRequest;
import com.project.movieApp.responses.CommentResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CommentService {

    private CommentRepository commentRepository;
    private UserService userService;
    private FilmService filmService;


    public List<CommentResponse> getAllComments(Optional<Long> userId, Optional<Long> filmId) {

        List<Comment> comments;
        if (userId.isPresent() && filmId.isPresent()) {
            comments = commentRepository.findByUserIdAndFilmId(userId.get(), filmId.get());
        } else if (userId.isPresent()) {
            comments = commentRepository.findByUserId(userId.get());
        } else if (filmId.isPresent()) {
            comments = commentRepository.findByFilmId(filmId.get());
        }else
            comments = commentRepository.findAll();
        return comments.stream().map(comment -> new CommentResponse(comment)).collect(Collectors.toList());
    }

    public Comment getOneComment(Long commentId) {

        return commentRepository.findById(commentId).orElse(null);
    }

    public Comment createOneComment(CreateCommentRequest newCommentRequest) {

        User user = userService.getOneUser(newCommentRequest.getUserId());
        Film film = filmService.getOneFilm(newCommentRequest.getFilmId());

        if (user != null && film != null) {
            Comment newComment = new Comment();
            newComment.setUser(user);
            newComment.setFilm(film);
            newComment.setId(newCommentRequest.getId());
            newComment.setText(newCommentRequest.getText());
            return commentRepository.save(newComment);
        }
        return null;
    }

    public Comment updateComment(UpdateCommentRequest updateCommentRequest) {
        return commentRepository.findById(updateCommentRequest.getCommentId())
                .map(comment -> {
                    comment.setText(updateCommentRequest.getText());
                    return commentRepository.save(comment);
                })
                .orElse(null);
    }

    public void deleteComment(Long commentId) {

        commentRepository.deleteById(commentId);
    }
}
