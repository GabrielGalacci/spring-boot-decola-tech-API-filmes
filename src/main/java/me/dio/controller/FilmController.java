package me.dio.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.dio.service.FilmService;

@CrossOrigin
@RestController
@RequestMapping("/films")
public record FilmController(FilmService filmService) {

}
