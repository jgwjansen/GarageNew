package com.example.garagenew.domein;

import com.example.garagenew.domein.enumerations.RolEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Gebruiker{

    @Id
    private Long id;

    private String gebruikersnaam;

    private String wachtwoord;

    private RolEnum rollen;
}