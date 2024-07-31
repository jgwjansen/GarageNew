package com.example.garagenew.domein;
import com.example.garagenew.domein.enumerations.OnderdeelType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Onderdeel {
    @Id
    private long id;

    private OnderdeelType onderdeelType;

    private String merk;

    private String naam;

    private long voorraadAanwezig;
}
