package com.scaler.bookmyshowjan23.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Show extends BaseModel {
    // S:A -> 1:1  M:1
    @ManyToOne
    private Auditorium auditorium;
    // S:M 1:1  M:1
    @ManyToOne
    private Movie movie;
    private Date startTime;
    private Date endTime;
    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Feature> features;
}
