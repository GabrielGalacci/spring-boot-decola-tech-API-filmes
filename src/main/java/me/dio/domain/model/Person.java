package me.dio.domain.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String fullName;

    private String aka;

    private Integer age;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    private String birthplaceState;

    private String birthplaceCountry;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAka() {
        return aka;
    }

    public void setAka(String aka) {
        this.aka = aka;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthplaceState() {
        return birthplaceState;
    }

    public void setBirthplaceState(String birthplaceState) {
        this.birthplaceState = birthplaceState;
    }

    public String getBirthplaceCountry() {
        return birthplaceCountry;
    }

    public void setBirthplaceCountry(String birthplaceCountry) {
        this.birthplaceCountry = birthplaceCountry;
    }
}
