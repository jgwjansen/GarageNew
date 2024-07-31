package com.example.garagenew.domein;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Afspraak{

    @Id
    private Long id;
    private LocalDateTime datumTijd;
    private double totale_kosten;

    @ManyToOne
    private Auto auto;

    @ManyToOne
    private Monteur monteur;

    @OneToMany
    private List<Handeling> handelingen;


}