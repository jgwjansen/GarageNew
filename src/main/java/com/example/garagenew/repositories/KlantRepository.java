package com.example.garagenew.repositories;


import com.example.garagenew.domein.Klant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KlantRepository extends JpaRepository<Klant,Long> {
}
