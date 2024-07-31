package com.example.garagenew.controller.controllers;


import com.example.garagenew.domein.Auto;
import com.example.garagenew.repository.AutoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/auto")
public class AutoController {

    final AutoRepository autoRepository;

    public AutoController(AutoRepository autoRepository) {

        this.autoRepository = autoRepository;
    }

    @GetMapping
    public List<Auto> getAuto(){

        return autoRepository.findAll();
    }

}
