package me.dio.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import me.dio.controller.dto.FilmDTO;
import me.dio.service.FilmService;

@CrossOrigin
@RestController
@RequestMapping("/films")
public record FilmController(FilmService filmService) {

    @GetMapping
    public ResponseEntity<List<FilmDTO>> findAll() {
        var films = filmService.findaAll();
        var filmsDto = films.stream().map(FilmDTO::new).collect(Collectors.toList());

        return ResponseEntity.ok(filmsDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilmDTO> findById(@PathVariable Long id) {
        var film = filmService.findById(id);
        return ResponseEntity.ok(new FilmDTO(film));
    }

    @PostMapping
    public ResponseEntity<FilmDTO> create(@RequestBody FilmDTO filmDTO) {
        var film = filmService.create(filmDTO.toModel());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(film.getId())
                .toUri();
        return ResponseEntity.created(location).body(new FilmDTO(film));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FilmDTO> update(@PathVariable Long id, @RequestBody FilmDTO filmDTO) {
        var film = filmService.update(id, filmDTO.toModel());
        return ResponseEntity.ok(new FilmDTO(film));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        filmService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
