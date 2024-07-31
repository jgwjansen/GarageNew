package com.example.garagenew.domein;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Setter;

@Entity
@Setter
public class Keuring extends Afspraak {

    @Id
    private Long id;
    private double kosten;

}
