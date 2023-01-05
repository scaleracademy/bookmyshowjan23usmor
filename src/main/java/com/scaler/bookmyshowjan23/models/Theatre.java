package com.scaler.bookmyshowjan23.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Theatre extends BaseModel {
    private String name;
    private String address;
    // T:C -> 1:1 ->  M:1
    @ManyToOne
    private City city;

    // T:A -> 1: M  >   1:1
    @OneToMany(mappedBy = "theatre")
    private List<Auditorium> auditoriums;
}
