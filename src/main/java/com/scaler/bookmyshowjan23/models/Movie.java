package com.scaler.bookmyshowjan23.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Movie extends BaseModel {
    private String name;
    @Enumerated(EnumType.ORDINAL)
    private Language language;
    // M:A 1:M   M:1
    @ManyToMany
    private List<Actor> cast;
}
