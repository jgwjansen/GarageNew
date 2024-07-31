package com.example.garagenew.domein;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Monteur {
    @Id
    private long id;
    private String naam;



}
