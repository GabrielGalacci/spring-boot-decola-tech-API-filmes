package me.dio.controller.dto;

import java.time.LocalDate;

import me.dio.domain.model.Producer;

public record ProducerDTO(Long id, String fullName, String aka, Integer age, LocalDate birthDate, String birthplaceState, String birthplaceCountry) {
    
    public ProducerDTO(Producer model) {
        this(model.getId(), model.getFullName(), model.getAka(), model.getAge(), model.getBirthDate(), model.getBirthplaceState(), model.getBirthplaceCountry());
    }

    public Producer toModel() {
        Producer model = new Producer();
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
