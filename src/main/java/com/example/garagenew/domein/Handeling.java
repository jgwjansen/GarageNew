package com.example.garagenew.domein;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Handeling {
    @Id
    private Long id;
    private String soort;
    private double kosten;

    @ManyToOne
    private Monteur monteur;
    private String actie;


}
