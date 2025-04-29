package me.dio.controller.dto;

import java.time.LocalDate;

import me.dio.domain.model.ProductionCompany;

public record ProductionCompanyDTO(Long id, String name, LocalDate foundationDate, String headquartersState, String headquartersCountry) {

    public ProductionCompanyDTO(ProductionCompany model) {
        this(model.getId(), model.getName(), model.getFoundationDate(), model.getHeadquartersState(), model.getHeadquartersCountry());
    }

    public ProductionCompany toModel(){
        ProductionCompany model = new ProductionCompany();
        if (this.id != null) { // Only set id if it is present
            model.setId(this.id);
        }
        model.setName(this.name);
        model.setFoundationDate(this.foundationDate);
        model.setHeadquartersState(this.headquartersState);
        model.setHeadquartersCountry(this.headquartersCountry);

        return model;
    }

}
