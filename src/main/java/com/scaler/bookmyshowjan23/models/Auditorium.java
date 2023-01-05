package com.scaler.bookmyshowjan23.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Auditorium extends BaseModel {
    @ManyToOne
    private Theatre theatre; // A:T -> L 1:1 R   M:1 -> M:1
    private String name;

    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Feature> features;
    @OneToMany
    private List<Seat> seats; // A:S -> 1:M  1:1
}
