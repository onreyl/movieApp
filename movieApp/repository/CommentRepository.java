package com.project.movieApp.repository;

import com.project.movieApp.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByUserIdAndFilmId(Long User, Long Film);

    List<Comment> findByUserId(Long User);

    List<Comment> findByFilmId(Long Film);
}
