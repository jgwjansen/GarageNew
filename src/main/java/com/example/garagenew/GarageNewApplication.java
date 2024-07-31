package com.example.garagenew;

import com.example.garagenew.domein.Gebruiker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GarageNewApplication {

    public static Gebruiker ingelogdeGebruiker = new Gebruiker();
    public static void main(String[] args) {
        SpringApplication.run(GarageNewApplication.class, args);
    }

}
