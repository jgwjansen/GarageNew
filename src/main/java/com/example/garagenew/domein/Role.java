package com.example.garagenew.domein;

import com.example.garagenew.domein.enumerations.RolEnum;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private RolEnum name;


}