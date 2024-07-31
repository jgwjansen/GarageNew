package com.example.garagenew.domein;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Auto {

    @Id
    private Long id;
    @OneToOne
    private Klant klant;
    private String model;
    private String kenteken;
    private String autopapieren;


}
