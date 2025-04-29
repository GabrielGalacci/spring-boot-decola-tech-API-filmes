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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.dio.controller.dto.FilmDTO;
import me.dio.service.FilmService;

@CrossOrigin
@RestController
@RequestMapping("/films")
@Tag(name = "Films Controller", description = "RESTful API for managing films")
public record FilmController(FilmService filmService) {

    @GetMapping
    @Operation(summary = "Get all Films", description = "Retrieve a list of all registered films.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Operation Successful")
    })
    public ResponseEntity<List<FilmDTO>> findAll() {
        var films = filmService.findaAll();
        var filmsDto = films.stream().map(FilmDTO::new).collect(Collectors.toList());

        return ResponseEntity.ok(filmsDto);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a Film by ID", description = "Retrieve a specific film based on its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Operation successful"),
        @ApiResponse(responseCode = "400", description = "Film not found")
    })
    public ResponseEntity<FilmDTO> findById(@PathVariable Long id) {
        var film = filmService.findById(id);
        return ResponseEntity.ok(new FilmDTO(film));
    }

    @PostMapping
    @Operation(summary = "Create a new Film", description = "Create a new Film and return the created film's data")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Film created successfully"),
        @ApiResponse(responseCode = "422", description = "Invalid Film data provided")
    })
    public ResponseEntity<FilmDTO> create(@RequestBody FilmDTO filmDTO) {
        var film = filmService.create(filmDTO.toModel());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(film.getId())
                .toUri();
        return ResponseEntity.created(location).body(new FilmDTO(film));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a Film", description = "Update the data of an existing user based on its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Film updated successfully"),
        @ApiResponse(responseCode = "404", description = "Film not found"),
        @ApiResponse(responseCode = "422", description = "Invalid film data provided")
    })
    public ResponseEntity<FilmDTO> update(@PathVariable Long id, @RequestBody FilmDTO filmDTO) {
        var film = filmService.update(id, filmDTO.toModel());
        return ResponseEntity.ok(new FilmDTO(film));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a Film", description = "Delete an existing Film based on its ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Film deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Film not found")
    })
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        filmService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
