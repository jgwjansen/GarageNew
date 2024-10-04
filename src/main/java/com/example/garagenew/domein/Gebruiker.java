package com.example.garagenew.domein;

import com.example.garagenew.domein.enumerations.RolEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@Builder
/*
All args is het zelfde als een constructor die alle parameters heeft
no-args constructor is een zonder parameters.
Lombok is een dependency die heel veel boiler plate code voor je maakt
dus de no-args constructor annotatie maakt de een constructor voor je aan als je het project build.
 */
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Gebruiker{

    //Id geeft aan dat het de id is van deze regel in de database. Id's moeten uniek en aanwezig zijn.
    @Id
    //Generated value zorgt ervoor dat deze waarde automatisch gevuld wordt en uniek is bij het opslaan in de database
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 50)
    private String username;

    @NotBlank
    private String wachtwoord;

    @Email
    private String emailadres;

    //Meerdere gebruikers kunnen meerdere rollen hebben en deze kunnen ook hetzelfde zijn.
    @ManyToMany(fetch = FetchType.LAZY)
    //Om te zorgen dat je niet handmatig zelf hoeft te zegggen welke users welke rollen hebben kun je deze annotatie gebruiken.
    //Deze maakt een nieuwe tabel in je database waar gebruikers in staan met hun rollen op basis van de id van de gebruiker en de id van de rol.
    //(check de tabel GEBRUIKER_ROLES na het aanmaken van een account te zien hoe het er uit ziet)
    @JoinTable(name = "gebruiker_roles",
            joinColumns = @JoinColumn(name = "gebruiker_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @ToString.Exclude
    private Set<Role> roles = new HashSet<>();


    //En eigenschappen die een acount nog meer nodig heeft
}