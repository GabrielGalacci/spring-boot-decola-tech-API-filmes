package me.dio.controller.dto;

import static java.util.Collections.emptyList;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;

import java.util.Date;
import java.util.List;

import me.dio.domain.model.Film;

public record FilmDTO(
    Long id,
    String filmName,
    String genre,
    Date releaseYear,
    Integer lengthMinutes,
    String parentalRating,
    Double rating,
    ProductionCompanyDTO productionCompany,
    ProducerDTO producer,
    List<CastDTO> castMembers
) {

    public FilmDTO(Film model) {
        this(
            model.getId(),
            model.getName(),
            model.getGenre(),
            model.getReleaseYear(),
            model.getLengthMinutes(),
            model.getParentalRating(),
            model.getRating(),
            ofNullable(model.getProductionCompany()).map(ProductionCompanyDTO::new).orElse(null),
            ofNullable(model.getProducer()).map(ProducerDTO::new).orElse(null),
            ofNullable(model.getCast()).orElse(emptyList()).stream().map(CastDTO::new).collect(toList())
        );
    }

    public Film toModel() {
        Film model = new Film();
        if (this.id != null) { // Only set id if it is present
            model.setId(this.id);
        }
        model.setName(this.filmName);
        model.setGenre(this.genre);
        model.setReleaseYear(this.releaseYear);
        model.setLengthMinutes(this.lengthMinutes);
        model.setParentalRating(this.parentalRating);
        model.setRating(this.rating);
        model.setProductionCompany(ofNullable(this.productionCompany).
            map(ProductionCompanyDTO::toModel).
            orElse(null));
        model.setProducer(ofNullable(this.producer).
            map(ProducerDTO::toModel).
            orElse(null));
        model.setCast(ofNullable(this.castMembers).
            orElse(emptyList()).stream().map(CastDTO::toModel).
            collect(toList()));

        return model;
    }
}
