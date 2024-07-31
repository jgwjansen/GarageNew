package com.example.garagenew.controller.controllers;

import com.example.garagenew.domein.Klant;
import com.example.garagenew.repository.KlantRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("api/klant")
public class KlantController {

    final KlantRepository klantRepository;

    public KlantController(KlantRepository klantRepository) {
        this.klantRepository = klantRepository;
    }

//    @GetMapping
//    //Haalt  klantgegevens op
//    public String getKlant(){
//
//        return Garage2Application.ingelogdeGebruiker.getRollen().toString();
//    }


    @PostMapping
    //Maakt nieuwe klant aan
    private ResponseEntity<?> postKlant(@RequestBody Klant klant){
        if(!Objects.equals(klant.getNaam(), "")){
            Klant newKlant = new Klant();
            newKlant.setNaam(klant.getNaam());
            klantRepository.save(newKlant);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
