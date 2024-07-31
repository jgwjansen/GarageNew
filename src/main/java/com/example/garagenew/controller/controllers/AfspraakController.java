package com.example.garagenew.controller.controllers;

import com.example.garagenew.domein.Afspraak;
import com.example.garagenew.repository.AfspraakRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping ("api/afspraak")
public class AfspraakController {


    final AfspraakRepository afspraakrepository;

    public AfspraakController(AfspraakRepository afspraakRepository) {

        this.afspraakrepository = afspraakRepository;
    }

    @GetMapping
    public List<Afspraak> getAfspraak(){

        return afspraakrepository.findAll();
    }

}
