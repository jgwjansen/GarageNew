package com.example.garagenew.controller.controllers;

import com.example.garagenew.domein.Role;
import com.example.garagenew.domein.enumerations.RolEnum;
import com.example.garagenew.repository.RoleRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/initial")
@RestController
public class InitializerController {

    RoleRepository roleRepository;

    InitializerController(RoleRepository roleRes){
        roleRepository = roleRes;
    }

    @GetMapping("/database")
    public void initializeDatabase(){
        Role user = new Role();
        user.setName(RolEnum.USER);
        roleRepository.save(user);

        Role admin = new Role();
        admin.setName(RolEnum.ADMIN);
        roleRepository.save(admin);
    }

}
