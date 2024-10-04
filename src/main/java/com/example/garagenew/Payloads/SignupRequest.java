package com.example.garagenew.Payloads;

import com.example.garagenew.domein.enumerations.RolEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.util.Set;

@Getter
@Setter
@ToString
public class SignupRequest {
    //Het gebruik van een payload-class is niet verplicht, maar het maakt het makkelijk om niet afhankelijk te zijn van de velden binnen een object.
    //Je zou hier ook een variabel heeft avondgegeten toe kunnen voegen als je dat zou willen en die dan niet overzetten naar het user object.
    //Soms is het handiger om de een of de ander te gebruiken. Voor users aanmaken zou ik gelijk het object overzetten.
    //Dit is meer even een voorbeeld van hoe het kan.


    //de namen van de variabelen komen overeen zoals ze in het reqest zijn

    @NotBlank
    private String username;

    @NotBlank
    private String wachtwoord;

    private String email;

    private Set<RolEnum> rollen;

    //andere velden die nodig zijn om een account aan te maken.
    // Velden die niet verplicht zijn moeten hier wel opgenomen worden maar zijn dan gewoon null.

}
