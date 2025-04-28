package me.dio.controller.dto;

import java.util.Date;

import me.dio.domain.model.ProductionCompany;

public record ProductionCompanyDTO(Long id, String name, Date foundationDate, String headwaurtersState, String headquartersCountry) {

    public ProductionCompanyDTO(ProductionCompany model) {
        this(model.getId(), model.getName(), model.getFoundationDate(), model.getHeadquartersState(), model.getHeadquartersCountry());
    }

    public ProductionCompany toModel(){
        ProductionCompany model = new ProductionCompany();
        model.setId(this.id);
        model.setName(this.name);
        model.setFoundationDate(this.foundationDate);
        model.setHeadquartersState(this.headwaurtersState);
        model.setHeadquartersCountry(this.headquartersCountry);

        return model;
    }

}
