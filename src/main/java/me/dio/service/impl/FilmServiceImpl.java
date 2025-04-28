package me.dio.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.dio.domain.model.Film;
import me.dio.domain.repositories.FilmRepository;
import me.dio.service.FilmService;
import me.dio.service.exception.BusinessException;

import static java.util.Optional.ofNullable;

@Service
public class FilmServiceImpl implements FilmService {

    private static final long UNCHANGEABLE_FILM_ID = 1L;

    private final FilmRepository filmRepository;

    public FilmServiceImpl(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Transactional(readOnly = true)
    public List<Film> findaAll() {
        return this.filmRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Film findById(Long id) {
        return this.filmRepository.findById(id).orElseThrow();
    }


    @Transactional
    public Film create(Film filmToCreate) {
        ofNullable(filmToCreate).orElseThrow(() -> new BusinessException("Film to create must not be null."));
        ofNullable(filmToCreate.getProductionCompany()).orElseThrow(() -> new BusinessException("Production Company must not be null."));
        ofNullable(filmToCreate.getProducer()).orElseThrow(() -> new BusinessException("Producer must not be null."));
        ofNullable(filmToCreate.getCast()).orElseThrow(() -> new BusinessException("Cast must not be null."));

        this.validateChangeableId(filmToCreate.getId(), "created");
        if (filmRepository.existsByFilmName(filmToCreate.getName())) {
            throw new BusinessException("This Film already exists!");
        }
        return this.filmRepository.save(filmToCreate);
    }

    @Transactional
    public Film update(Long id, Film filmToUpdate) {
        this.validateChangeableId(id, "updated");
        Film dbFilm = this.findById(id);
        if (dbFilm.getId() != filmToUpdate.getId()) {
            throw new BusinessException("Update IDs must be the same!");
        }

        dbFilm.setName(filmToUpdate.getName());
        dbFilm.setGenre(filmToUpdate.getGenre());
        dbFilm.setReleaseYear(filmToUpdate.getReleaseYear());
        dbFilm.setLengthMinutes(filmToUpdate.getLengthMinutes());
        dbFilm.setParentalRating(filmToUpdate.getParentalRating());
        dbFilm.setRating(filmToUpdate.getRating());
        dbFilm.setProductionCompany(filmToUpdate.getProductionCompany());
        dbFilm.setProducer(filmToUpdate.getProducer());
        dbFilm.setCast(filmToUpdate.getCast());

        return this.filmRepository.save(dbFilm);
    }

    @Transactional
    public void delete(Long id) {
        this.validateChangeableId(id, "deleted");
        Film dbFilm = this.findById(id);
        this.filmRepository.delete(dbFilm);
    }

    private void validateChangeableId(Long id, String operation) {
        if (UNCHANGEABLE_FILM_ID == id) {
            throw new BusinessException("Film with ID %d can not be %s.".formatted(UNCHANGEABLE_FILM_ID, operation));
        }
    }

}
