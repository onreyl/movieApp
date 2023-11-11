package com.project.movieApp.controllers;

import com.project.movieApp.entities.Film;
import com.project.movieApp.services.FilmService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/films")
@AllArgsConstructor
public class FilmController {

    private FilmService filmService;


    @GetMapping("/getAll")
    public List<Film> getAllFilms(){

        return filmService.getAllFilms();
    }

    @GetMapping("/{filmId}")
    public Film getOneFilm(@PathVariable Long filmId){

        return filmService.getOneFilm(filmId);
    }

    @PostMapping("/add")
    public Film createOneFilm(@RequestBody Film newFilm){
        return filmService.createOneFilm(newFilm);
    }

    @PutMapping("/update")
    public Film updateFilm(@PathVariable Long id,@RequestBody Film newFilm){

        return filmService.updateFilm(id, newFilm);
    }

    @DeleteMapping("/{id}")
    public void deleteFilm(@PathVariable Long filmId){

        filmService.deleteFilm(filmId);
    }

}
