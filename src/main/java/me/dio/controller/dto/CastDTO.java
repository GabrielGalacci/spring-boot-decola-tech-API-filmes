package me.dio.controller.dto;

import java.util.Date;

import me.dio.domain.model.CastMember;


public record CastDTO(Long id, String fullName, String aka, Integer age, Date birthDate, String birthplaceState, String birthplaceCountry) {

    public CastDTO(CastMember model) {
        this(model.getId(), model.getFullName(), model.getAka(), model.getAge(), model.getBirthDate(), model.getBirthplaceState(), model.getBirthplaceCountry());
    }

    public CastMember toModel() {
        CastMember model = new CastMember();
        if (this.id != null) { // Only set id if it is present
            model.setId(this.id);
        }
        model.setFullName(this.fullName);
        model.setAka(this.aka);
        model.setAge(this.age);
        model.setBirthDate(this.birthDate);
        model.setBirthplaceState(this.birthplaceState);
        model.setBirthplaceCountry(this.birthplaceCountry);

        return model;
    }
}
