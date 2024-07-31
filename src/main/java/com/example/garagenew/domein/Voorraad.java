package com.example.garagenew.domein;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class Voorraad{

    @Id
    private Long id;
    @OneToMany
    private List<Onderdeel> onderdelenAanwezig;
}
