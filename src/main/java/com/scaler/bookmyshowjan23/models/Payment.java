package com.scaler.bookmyshowjan23.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment extends BaseModel {
    private String referenceNumber;

    @Enumerated(EnumType.ORDINAL)
    private PaymentProvider provider;
}
