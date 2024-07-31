package com.example.garagenew.controller.controllers;

import com.example.garagenew.domein.Klant;
import com.example.garagenew.repository.KlantRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("api/klant")
public class KlantController {

    final KlantRepository klantRepository;

    public KlantController(KlantRepository klantRepository) {
        this.klantRepository = klantRepository;
    }

    @GetMapping
    //Haalt  klantgegevens op
    public List<Klant> getKlant(){

        return klantRepository.findAll();
    }

    @GetMapping("/{id}")
    //Haalt  klantgegevens op
    public ResponseEntity<?> getKlant(@PathVariable("id") Long id){
        System.out.println(id);

        Optional<Klant> klant = klantRepository.findById(id);
        if(klant.isPresent()){
            return ResponseEntity.ok(klant);
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping
    //Maakt nieuwe klant aan
    private ResponseEntity<?> postKlant(@RequestBody Klant klant){
        if(!Objects.equals(klant.getNaam(), "")){
            Klant newKlant = new Klant();
            newKlant.setNaam(klant.getNaam());
            klantRepository.save(klant);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
