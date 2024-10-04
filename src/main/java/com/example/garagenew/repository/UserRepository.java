package com.example.garagenew.repository;

import com.example.garagenew.domein.Gebruiker;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotBlank;

public interface UserRepository extends JpaRepository<Gebruiker,Integer> {
     boolean existsByUsername(@NotBlank String username);

     Gebruiker findByUsername(@NotBlank String username);
}
