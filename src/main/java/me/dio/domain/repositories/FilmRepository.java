package me.dio.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.dio.domain.model.Film;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {

    boolean existsByFilmName(String name);

}
