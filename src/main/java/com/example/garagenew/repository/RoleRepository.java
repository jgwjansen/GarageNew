package com.example.garagenew.repository;

import com.example.garagenew.domein.Role;
import com.example.garagenew.domein.enumerations.RolEnum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    Role findByName(RolEnum name);
}
