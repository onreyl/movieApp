package com.project.movieApp.services;

import com.project.movieApp.entities.Film;
import com.project.movieApp.repository.FilmRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@AllArgsConstructor
public class FilmService {

    FilmRepository filmRepository;

    public List<Film> getAllFilms(){

        return filmRepository.findAll();
    }

    public Film createOneFilm(Film newFilm){

        return filmRepository.save(newFilm);
    }

    public Film getOneFilm(Long id){

        return filmRepository.findById(id).orElse(null);
    }

    public Film updateFilm(Long id, Film newFilm) {

        return filmRepository.findById(id).map(film -> {
            film.setTitle(newFilm.getTitle());
            film.setDirector(newFilm.getDirector());
            film.setReleaseYear(newFilm.getReleaseYear());
            return filmRepository.save(film);
        }).orElse(null);
    }

    public void deleteFilm(@PathVariable Long id){

        filmRepository.deleteById(id);
    }

}
