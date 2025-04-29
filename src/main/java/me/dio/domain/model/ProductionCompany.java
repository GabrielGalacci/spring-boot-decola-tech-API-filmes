package me.dio.domain.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "tb_production_company")
public class ProductionCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate foundationDate;

    private String headquartersState;

    private String headquartersCountry;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getFoundationDate() {
        return foundationDate;
    }

    public void setFoundationDate(LocalDate foundationDate) {
        this.foundationDate = foundationDate;
    }

    public String getHeadquartersState() {
        return headquartersState;
    }

    public void setHeadquartersState(String headquartersState) {
        this.headquartersState = headquartersState;
    }

    public String getHeadquartersCountry() {
        return headquartersCountry;
    }

    public void setHeadquartersCountry(String headquartersCountry) {
        this.headquartersCountry = headquartersCountry;
    }
}
